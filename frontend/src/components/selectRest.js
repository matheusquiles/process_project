import React from 'react';
import axios from 'axios';
import { useEffect, useCallback, useState } from 'react';
import { InputLabel, StyledSelect } from '../styles/formulario';
import { GenericP } from '../styles/globalstyles';
import { API_BASE_URL } from '../helpers/constants';

export default function SelectRest({ label, first, topless, imgW, small, route, id, name, onChange, form }) {
  const [isLoading, setIsLoading] = useState(true);
  const [options, setOptions] = useState([]);
  const [selected, setSelected] = useState({ id: '', name: '' });

  const getData = useCallback(async () => {
    try {
      const thisOptions = [];
      const { data } = await axios.get(`${ API_BASE_URL }/${ route }`);

      data.map((obj) => thisOptions.push({ id: obj[id], name: obj[name] }));
      
      setOptions(thisOptions);
      setSelected({ id: thisOptions[0].id, name: thisOptions[0].name })
      setIsLoading(false);
    } catch (error) { console.log('deu erro na req') }
  }, []);

  function handleSelect({ target: { value, innerText } }) {
    const newValue = Number(value);
    setSelected({ id: value, name: innerText });
    onChange({ ...form, [route]: newValue })
  }

  useEffect(() => {
    if (!options.length) getData();
  }, [getData]);

  return (
    isLoading
    ? <p>Tá carregando parsa</p>
    : (
      <InputLabel first={ first } topless={ topless } imgW={ imgW } small={ small } >
        <GenericP>{ label }:</GenericP>
        <StyledSelect onChange={ handleSelect } value={ selected.id }>
          { options.map(({ id, name }) => <option key={ name } value={ id }>{ name }</option>) }
        </StyledSelect>
      </InputLabel>
    )
  );
}