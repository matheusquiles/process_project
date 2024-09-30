import React from 'react';
import { InputLabel, Input } from '../styles/formulario';
import { GenericP } from '../styles/globalstyles';
// import { faCircleCheck } from '@fortawesome/free-solid-svg-icons';
// import { useEffect, useState } from 'react';
// import { validateText } from '../../helpers/functions/formValidations';
// import { validateEmail } from '../../helpers/functions/validations';



export default function TextInput({ label, fieldName, first, topless, imgW, small, formData, setFormData }) {

  const handleChange = ({ target: { value } }) => {
    setFormData(prevFormData => ({
      ...prevFormData,
      [fieldName]: value,
    }));
  };

  return (
    <InputLabel first={first} topless={topless} imgW={imgW} small={small}>
      <GenericP>{label}:</GenericP>
      <Input
        id={label}
        type="text"
        value={formData?.[fieldName] || ''} 
        onChange={handleChange}
      />
    </InputLabel>
  );


  // const [text, setText] = useState('');

  // function handleChange({ target: { value } }) {
  //   setText(value);
  //   setShowIcon(isEmail ? validateEmail(value) : validateText(value));
  //   onChange({ target: { id, value } });
  // }

  // function handleFocus({ type }) {
  //   const isEmpty = isEmail ? !validateEmail(text) : !validateText(text);
  //   const onFocus = type === 'focus';

  //   setFocus(onFocus);
  //   setInvalid(isEmpty && !onFocus);
  // }

  // useEffect(() => {
  //   if (defaultValue) {
  //     setShowIcon(validateText(defaultValue));
  //     setText(defaultValue);
  //   }
  // }, [defaultValue]);


}