import React from 'react';
import { InputLabel, InputMoney } from '../styles/formulario';
import { GenericP } from '../styles/globalstyles';
import { NumericFormat } from 'react-number-format';

export default function MoneyImput({ label, fieldName, first, topless, imgW, small, mediumPlus, formData, medium, setFormData, value, onChange, disabled = false }) {
    
    const handleChange = (values) => {
        const { value: numericValue } = values;
        
        setFormData((prevFormData) => ({
          ...prevFormData,
          [fieldName]: numericValue,
        }));
    
        if (onChange) {
          onChange({ target: { name: fieldName, value: numericValue } });
        }
      };

    return (
        <InputLabel first={first} topless={topless} imgW={imgW} small={small} medium={medium} mediumPlus={mediumPlus}>
           <GenericP>{label}:</GenericP>
            <NumericFormat
                id={label}
                value={value || ''} 
                onValueChange={handleChange}
                thousandSeparator="."
                decimalSeparator=","
                prefix="R$ "
                decimalScale={2}
                fixedDecimalScale={true}
                customInput={InputMoney}
                disabled={disabled}
            />
        </InputLabel>
    )
};