import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Input from './components/input.js'
import SelectRest from './components/selectRest.js'
import DateImput from './components/date.js'
import MoneyImput from './components/money.js'
import * as F from './styles/formulario.jsx'
import ProcessoFormFields from './ProcessoFormFields';
import EstadoCidadeInput from './components/cidadeEstado.js';


const CadastroProcesso = () => {
  const [naturezaOptions] = useState([]);
  const [principalPedidoOptions] = useState([]);
  const [tribunalOptions] = useState([]);
  const [escritorioOptions] = useState([]);
  const [funcaoOptions, setFuncaoOptions] = useState([]);
  const [faseProcessualOptions] = useState([]);
  const [tipoAcaoOptions] = useState([]);
  const [classificacaoRiscoOptions] = useState([]);
  const [varaOptions, setVaraOptions] = useState([]);
  const [estados, setEstados] = useState([]);
  const [cidades, setCidades] = useState([]);
  const [estadoSelecionado, setEstadoSelecionado] = useState('');

  const [formData, setFormData] = useState({
    admissao: '',
    demissao: '',
    principal_pedido: '',
    ultimos_andamentos_processuais: '',
    valor_perda_estimado: '',
    deposito_recursal_ordinario: '',
    data_deposito_recursal_ordinario: '',
    deposito_recursal_revista: '',
    data_deposito_recursal_revista: '',
    deposito_judicial: '',
    data_deposito_judicial: '',
    bloqueio_judicial: '',
    data_bloqueio_judicial: '',
    estado: '', // Adiciona o campo estado
    cidade: ''  // Adiciona o campo cidade
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

  // useEffect(() => {
  //   //axios.get(`${apiBaseUrl}tribunal`).then(response => setTribunalOptions(response.data));
  //   // axios.get(`${apiBaseUrl}escritorio`).then(response => setEscritorioOptions(response.data));
  //   // axios.get(`${apiBaseUrl}natureza`).then(response => setNaturezaOptions(response.data));
  //   // axios.get(`${apiBaseUrl}funcao`).then(response => setFuncaoOptions(response.data));
  //   //axios.get(`${apiBaseUrl}vara`).then(response => setVaraOptions(response.data));
  //   //axios.get(`${apiBaseUrl}classificacaoRisco`).then(response => setClassificacaoRiscoOptions(response.data));
  //   axios.get('https://servicodados.ibge.gov.br/api/v1/localidades/estados').then(response => {
  //     setEstados(response.data.sort((a, b) => a.nome.localeCompare(b.nome)));
  //   });
  //   //axios.get(`${apiBaseUrl}faseProcessual`).then(response => setFaseProcessualOptions(response.data));
  //   //axios.get(`${apiBaseUrl}tipoAcao`).then(response => setTipoAcaoOptions(response.data));
  // }, []);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prevState => ({
      ...prevState,
      [name]: value
    }));
  };

  // const handleEstadoChange = (e) => {
  //   const estadoId = e.target.value;
  //   setEstadoSelecionado(estadoId);
  //   setFormData({ ...formData, estado: estadoId });

  //   axios.get(`https://servicodados.ibge.gov.br/api/v1/localidades/estados/${estadoId}/municipios`).then(response => {
  //     setCidades(response.data);
  //   });
  // };

  const handleSubmit = (e) => {
    e.preventDefault();
    const camelCaseFormData = convertKeysToCamelCase(formData);
    axios.post(`${apiBaseUrl}processo/salvar`, camelCaseFormData)
      .then(response => console.log('Processo criado com sucesso!', response.data))
      .catch(error => console.error('Erro ao criar o processo:', error));
  };


  return (
    <form onSubmit={handleSubmit} className="cadastro-processo-form">
      <F.LogoLine>
        <F.InputLine column>
          <F.InputLine>
            <SelectRest
              label="Escritório"
              first route='escritorio'
              id='idEscritorio'
              name='nomeEscritorio'
              onChange={setFormData}
              form={formData}
            />
            <Input
              label="Nº do Processo"
              fieldName="numeroProcesso"
              formData={formData}
              setFormData={setFormData}
            />
          </F.InputLine>

          <F.InputLine topless>
            <Input
              label="Autor" first
              fieldName="autor"
              formData={formData}
              setFormData={setFormData}
            />
            <SelectRest
              label="Fase Processual"
              route='faseProcessual'
              id='idFaseProcessual'
              name='faseProcessual'
              onChange={setFormData}
              form={formData}
            />
          </F.InputLine>
        </F.InputLine>

        <F.Logo src='/images/logo.jpg' alt='Logo' />
      </F.LogoLine>

      <F.InputLine>
        <Input
          label="Réu" first
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
        <SelectRest
          label="Classificação de Risco"
          imgW route='classificacaoRisco'
          id='idClassificacaoRisco'
          name='classificacaoRisco'
          onChange={setFormData}
          form={formData}
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
          />
          <SelectRest
            label="Tipo de Ação"
            small route='tipoAcao'
            id='idTipoAcao'
            name='tipoAcao'
            onChange={setFormData}
            form={formData}
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
        <SelectRest
          label="Vara" first
          route='vara'
          id='idVara'
          name='vara'
          onChange={setFormData}
          form={formData}
        />
        <SelectRest
          label="Função"
          route='funcao'
          id='idFuncao'
          name='funcao'
          onChange={setFormData}
          form={formData}
        />
      </F.InputLine>

      <F.InputLine>
        <F.InputLine>
          <EstadoCidadeInput
            label="Estado"
            first
            formData={formData}  
            setFormData={setFormData} 
          />
        </F.InputLine>
      </F.InputLine>


      <ProcessoFormFields
        formData={formData}
        handleChange={handleChange}
        estados={estados}
        cidades={cidades}
        estadoSelecionado={estadoSelecionado}
      // handleEstadoChange={handleEstadoChange}
      />

      <button type="submit">Cadastrar Processo</button>
    </form>
  );
};

export default CadastroProcesso;
