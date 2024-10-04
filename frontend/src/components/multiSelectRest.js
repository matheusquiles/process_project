import React, { useEffect, useCallback, useState } from 'react';
import axios from 'axios';
import { InputLabel, StyledSelect, SelectedItem, RemoveButton } from '../styles/formulario'; // Importa os estilos
import { GenericP } from '../styles/globalstyles';
import { API_BASE_URL } from '../helpers/constants';
import PropTypes from 'prop-types';

export default function MultiSelectRest({ label, first, topless, imgW, small, route, id, name, onChange, form, defaultValue, invalidFields }) {
  const [isLoading, setIsLoading] = useState(true);
  const [options, setOptions] = useState([]);
  const [selectedItems, setSelectedItems] = useState(defaultValue || []);

  const getData = useCallback(async () => {
    try {
      const thisOptions = [];
      const { data } = await axios.get(`${API_BASE_URL}/${route}`);

      data.map((obj) => thisOptions.push({ id: obj[id], name: obj[name] }));
      
      setOptions(thisOptions);
      setIsLoading(false);
    } catch (error) { console.log('Erro na requisição:', error); }
  }, [route, id, name]);

  const handleSelect = ({ target: { value } }) => {
    const selectedItem = options.find(option => option.id === Number(value));

    if (selectedItem && !selectedItems.some(item => item.id === selectedItem.id)) {
      const newSelectedItems = [...selectedItems, selectedItem];
      setSelectedItems(newSelectedItems);
      onChange(prevForm => ({
        ...prevForm,
        [route]: newSelectedItems.map(item => item.id)
      }));
    }
  };

  const removeItem = (itemId) => {
    const newSelectedItems = selectedItems.filter(item => item.id !== itemId);
    setSelectedItems(newSelectedItems);
    onChange(prevForm => ({
      ...prevForm,
      [route]: newSelectedItems.map(item => item.id)
    }));
  };

  useEffect(() => {
    if (!options.length) getData();
  }, [getData, options.length]);

  const isInvalid = invalidFields.includes(route);

  return (
    isLoading ? <p>Carregando...</p> : (
      <InputLabel first={first} topless={topless} imgW={imgW} small={small} style={{ borderColor: isInvalid ? 'red' : 'inherit' }}>
        <GenericP>{label}:</GenericP>

        {/* Dropdown de seleção */}
        <StyledSelect onChange={handleSelect} value="">
          <option value="">{`Selecione`}</option>
          {options.map(({ id, name }) => (
            <option key={id} value={id} disabled={selectedItems.some(item => item.id === id)}>
              {name}
            </option>
          ))}
        </StyledSelect>

        {/* Lista de itens selecionados abaixo */}
        <div style={{ marginTop: '10px' }}>
          {selectedItems.map(item => (
            <SelectedItem key={item.id}>
              {item.name}
              <RemoveButton onClick={() => removeItem(item.id)}>
                &times;
              </RemoveButton>
            </SelectedItem>
          ))}
        </div>

        {isInvalid && <span style={{ color: 'red' }}>Este campo é obrigatório.</span>}
      </InputLabel>
    )
  );
}
