import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Input from './components/input.js'
import SelectRest from './components/selectRest.js'
import DateImput from './components/date.js'
import MoneyImput from './components/money.js'
import * as F from './styles/formulario.jsx'
import EstadoCidadeInput from './components/cidadeEstado.js';
import MultiSelectRest from './components/multiSelectRest.js';


const CadastroProcesso = () => {
  const [invalidFields, setInvalidFields] = useState([]);

  const [formData, setFormData] = useState({
  });

  const apiBaseUrl = 'http://localhost:8080/api/';

  const toCamelCase = (str) => {
    return str.replace(/_([a-z])/g, (match, letter) => letter.toUpperCase());
  };

  const convertKeysToCamelCase = (obj) => {
    return Object.keys(obj).reduce((acc, key) => {
      const camelCaseKey = toCamelCase(key);
      acc[camelCaseKey] = obj[key];
      return acc;
    }, {});
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prevState => ({
      ...prevState,
      [name]: value
    }));
  };


  const validateFields = () => {
    const requiredFields = ['numeroProcesso', 'autor', 'reu', 'reclamada', 'escritorio', 'faseProcessual', 'classificacaoRisco',
      'natureza', 'tipoAcao', 'tribunal', 'vara', 'funcao']; // Campos que são obrigatórios
    const invalids = requiredFields.filter(field => !formData[field] || formData[field] === '');
    setInvalidFields(invalids);
    return invalids.length === 0;
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    if (validateFields()) {
      const camelCaseFormData = convertKeysToCamelCase(formData);
      axios.post(`${apiBaseUrl}processo/salvar`, camelCaseFormData)
        .then(response => console.log('Processo criado com sucesso!', response.data))
        .catch(error => console.error('Erro ao criar o processo:', error));
    } else {
      alert('Por favor, preencha todos os campos obrigatórios.');
    }
  };


  return (
    <form onSubmit={handleSubmit} className="cadastro-processo-form">
      <F.InputLine column>
        <F.InputLine>
          <SelectRest
            label="Escritório"
            first route='escritorio'
            id='idEscritorio'
            name='nomeEscritorio'
            onChange={setFormData}
            form={formData}
            defaultValue=""
            invalidFields={invalidFields}
          />
          <Input
            label="Nº do Processo"
            fieldName="numeroProcesso"
            formData={formData}
            setFormData={setFormData}
            invalidFields={invalidFields}
          />
          <SelectRest
            label="Fase Processual"
            route='faseProcessual'
            id='idFaseProcessual'
            name='faseProcessual'
            onChange={setFormData}
            defaultValue=""
            form={formData}
            invalidFields={invalidFields}
          />
        </F.InputLine>

        <F.InputLine topless>
          <Input
            label="Autor" first imgW
            fieldName="autor"
            formData={formData}
            setFormData={setFormData}
            invalidFields={invalidFields}
          />
          <Input
            label="Réu"
            fieldName="reu"
            formData={formData}
            setFormData={setFormData}
          />
          <Input
            label="Reclamada"
            fieldName="reclamada"
            formData={formData}
            setFormData={setFormData}
          />
        </F.InputLine>
      </F.InputLine>


      <F.InputLine>
        <SelectRest
          label="Vara" 
          first small route='vara'
          id='idVara'
          name='vara'
          onChange={setFormData}
          form={formData}
          defaultValue=""
          invalidFields={invalidFields}
        />
        <SelectRest
          label="Classificação de Risco"
          route='classificacaoRisco'
          id='idClassificacaoRisco'
          name='classificacaoRisco'
          onChange={setFormData}
          form={formData}
          defaultValue=""
          invalidFields={invalidFields}
        />
        <SelectRest
          label="Função"
          route='funcao'
          id='idFuncao'
          name='funcao'
          onChange={setFormData}
          form={formData}
          defaultValue=""
          invalidFields={invalidFields}
        />
      </F.InputLine>

      <F.InputLine>
        <F.SmallInputLine>
          <SelectRest
            label="Natureza"
            first route='natureza'
            id='idNatureza'
            name='natureza'
            onChange={setFormData}
            form={formData}
            defaultValue=""
            invalidFields={invalidFields}
          />
          <SelectRest
            label="Tipo de Ação"
            small route='tipoAcao'
            id='idTipoAcao'
            name='tipoAcao'
            onChange={setFormData}
            form={formData}
            defaultValue=""
            invalidFields={invalidFields}
          />
        </F.SmallInputLine>
        <F.SmallInputLine>
          <SelectRest
            label="Tribunal Origem"
            first route='tribunal'
            id='idTribunal'
            name='tribunalOrigem'
            onChange={setFormData}
            form={formData}
            defaultValue=""
            invalidFields={invalidFields}
          />
          <DateImput
            label="Data de Ajuizamento"
            small fieldName="dataAjuizamento"
            formData={formData}
            setFormData={setFormData}
          />
        </F.SmallInputLine>
        <MoneyImput
          label="Valor da Causa"
          first imgW fieldName="valorCausa"
          formData={formData}
          setFormData={setFormData} />
      </F.InputLine>

        <F.InputLine>
          <EstadoCidadeInput
            label="Estado"
            first
            formData={formData}
            setFormData={setFormData}
          />
        </F.InputLine>
        <F.InputLine>
          <MultiSelectRest
            label="Pedidos do Processo"
            first route='tipoPedido'
            id='idTipoPedido'
            name='descricao'
            onChange={setFormData}
            form={formData}
            defaultValue=""
            invalidFields={invalidFields}
          />
        </F.InputLine>

      <button type="submit">Cadastrar Processo</button>
    </form>
  );
};

export default CadastroProcesso;
