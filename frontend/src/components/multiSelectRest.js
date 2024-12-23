import React, { useEffect, useCallback, useState } from 'react';
import axios from 'axios';
import { useDispatch, useSelector } from 'react-redux';
import { setFormData, setOptions, setLoading } from '../redux/reducers/formSlice';
import { InputLabel, StyledSelect, SelectedItem, RemoveButton } from '../styles/formulario';
import { GenericP } from '../styles/globalstyles';
import { API_BASE_URL } from '../helpers/constants';

export default function MultiSelectRest({
  label, first, topless, imgW, small, route, id, name, 
  onChange, form, defaultValue = [], invalidFields, disabled = false 
}) {
  const dispatch = useDispatch();
  const isLoading = useSelector((state) => state.form.isLoading);
  const selectedItems = useSelector((state) => state.form.formData[route] || []);
  const options = useSelector((state) => state.form.options[route] || []);

  const [loadingDelay, setLoadingDelay] = useState(false);
  const isInvalid = invalidFields.includes(route);
  const isLoadingDelayed = loadingDelay || isLoading;

  const getData = useCallback(async () => {
    dispatch(setLoading(true));
    setLoadingDelay(true);
    try {
      const { data } = await axios.get(`${API_BASE_URL}/${route}`);
      const thisOptions = data.map((obj) => ({ id: obj[id], name: obj[name] }));
      dispatch(setOptions({ route, options: thisOptions }));
      await new Promise((resolve) => setTimeout(resolve, 2000)); // Simulação de atraso.
    } catch (error) {
      console.error('Erro na requisição:', error);
    } finally {
      dispatch(setLoading(false));
      setLoadingDelay(false);
    }
  }, [route, id, name, dispatch]);

  useEffect(() => {
    getData();
  }, [getData]);

  useEffect(() => {
    if (
      defaultValue.length > 0 &&
      JSON.stringify(defaultValue) !== JSON.stringify(selectedItems)
    ) {
      dispatch(setFormData({ [route]: defaultValue }));
      onChange(defaultValue.map(item => ({ idTipoPedido: item.id })));
    }
  }, [defaultValue, selectedItems, dispatch, onChange, route]); 

  const handleSelect = ({ target: { value } }) => {
    const selectedItem = options.find(option => option.id === Number(value));
  
    if (selectedItem && !selectedItems.some(item => item.id === selectedItem.id)) {
      const newSelectedItems = [...selectedItems, selectedItem];
  
      dispatch(setFormData({ [route]: newSelectedItems }));
      onChange(newSelectedItems);
    }
  };
  

  const removeItem = (itemId) => {
    const newSelectedItems = selectedItems.filter(item => item.id !== itemId);
    dispatch(setFormData({ [route]: newSelectedItems }));
    onChange(newSelectedItems.map(item => ({ idTipoPedido: item.id })));
  };

  return (
    <InputLabel
      first={first}
      topless={topless}
      imgW={imgW}
      small={small}
      style={{ borderColor: isInvalid ? 'red' : 'inherit' }}
    >
      <GenericP>{label}:</GenericP>

      <StyledSelect 
        onChange={handleSelect}
        value={isLoadingDelayed ? 'Carregando...' : ''}
        disabled={disabled}
      >
        <option value="">{isLoadingDelayed ? 'Carregando...' : 'Selecione'}</option>
        {options.map(({ id, name }) => (
          <option key={id} value={id} disabled={selectedItems.some(item => item.id === id)}>
            {name}
          </option>
        ))}
      </StyledSelect>

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
  );
}
