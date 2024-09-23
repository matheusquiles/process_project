import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './CadastroProcesso.css';

const CadastroProcesso = () => {
  const [naturezaOptions, setNaturezaOptions] = useState([]);
  const [principalPedidoOptions, setPrincipalPedidoOptions] = useState([]);
  const [tribunalOptions, setTribunalOptions] = useState([]);
  const [escritorioOptions, setEscritorioOptions] = useState([]); 
  const [funcaoOptions, setFuncaoOptions] = useState([]); 
  const [faseProcessualOptions, setFaseProcessualOptions] = useState([]); 
  const [tipoAcaoOptions, setTipoAcaoOptions] = useState([]); 

  const [estados, setEstados] = useState([]);
  const [cidades, setCidades] = useState([]);
  const [estadoSelecionado, setEstadoSelecionado] = useState('');
  
  const [formData, setFormData] = useState({
    escritorio: '',
    reclamada: '',
    natureza: '',
    autor: '',
    reu: '',
    funcao: '',
    admissao: '',
    demissao: '',
    numero_processo: '',
    tribunal: '',
    estado: '',
    cidade_origem: '',
    data_ajuizamento: '',
    principal_pedido: '',
    ultimos_andamentos: '',
    fase_processual: '',
    valor_causa: '',
    valor_perda_estimado: '',
    classificacao_risco: '',
    deposito_recursal_ordinario: '',
    data_deposito_recursal_ordinario: '',
    deposito_recursal_revista: '',
    data_deposito_recursal_revista: '',
    deposito_judicial: '',
    data_deposito_judicial: '',
    bloqueio_judicial: '',
    data_bloqueio_judicial: ''
  });

const apiBaseUrl = 'http://localhost:8080/api/';

  useEffect(() => {
    // Fetch tribunalOrigem options from API
    axios.get(`${apiBaseUrl}tribunal`)
      .then(response => {
        setTribunalOptions(response.data);
      })
      .catch(error => {
        console.error('There was an error fetching the Tribunal data!', error);
      });

    // Fetch escritorio options from API
    axios.get(`${apiBaseUrl}escritorio`)
      .then(response => {
        setEscritorioOptions(response.data);
      })
      .catch(error => {
        console.error('There was an error fetching the escritorio data!', error);
      });

    axios.get(`${apiBaseUrl}natureza`)
      .then(response => {
        setNaturezaOptions(response.data);
      })
      .catch(error => {
        console.error('There was an error fetching the natureza data!', error);
      });

      axios.get(`${apiBaseUrl}funcao`)
      .then(response => {
        setFuncaoOptions(response.data);
      })
      .catch(error => {
        console.error('There was an error fetching the função data!', error);
      });

      axios.get('https://servicodados.ibge.gov.br/api/v1/localidades/estados')
      .then(response => {
        // Ordenar os estados por nome
        const estadosOrdenados = response.data.sort((a, b) => a.nome.localeCompare(b.nome));
        setEstados(estadosOrdenados); // Atualiza a lista de estados
      })
      .catch(error => {
        console.error('Erro ao buscar estados:', error);
      });

      axios.get(`${apiBaseUrl}faseProcessual`)
      .then(response => {
        setFaseProcessualOptions(response.data);
      })
      .catch(error => {
        console.error('There was an error fetching the função data!', error);
      });

      axios.get(`${apiBaseUrl}tipoAcao`)
      .then(response => {
        setTipoAcaoOptions(response.data);
      })
      .catch(error => {
        console.error('There was an error fetching the tipo ação data!', error);
      });


  }, []);
  
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prevState => ({
      ...prevState,
      [name]: value
    }));
  };

  // Função chamada quando o estado for selecionado
  const handleEstadoChange = (e) => {
    const estadoId = e.target.value;
    setEstadoSelecionado(estadoId);
    setFormData({ ...formData, estado: estadoId });

    // Buscar as cidades do estado selecionado
    axios.get(`https://servicodados.ibge.gov.br/api/v1/localidades/estados/${estadoId}/municipios`)
      .then(response => {
        setCidades(response.data); // Atualiza a lista de cidades
      })
      .catch(error => {
        console.error('Erro ao buscar cidades:', error);
      });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    // Send form data to API
    axios.post(`${apiBaseUrl}processo/salvar`, formData)
      .then(response => {
        console.log('Form submitted successfully:', response.data);
      })
      .catch(error => {
        console.error('There was an error submitting the form!', error);
      });
  };

  

  return (
    <form onSubmit={handleSubmit}>
      <h1>Cadastro de Processo</h1>

      <label htmlFor="escritorio">Escritório:</label>
      <select id="escritorio" name="escritorio" onChange={handleChange}>
        <option value="">Selecione um escritório</option>
        {escritorioOptions.map(option => (
          <option key={option.idEscritorio} value={option.idEscritorio}>
            {option.nomeEscritorio}
          </option>
        ))}
      </select>

      <label htmlFor="reclamada">Reclamada:</label>
      <input type="text" id="reclamada" name="reclamada" maxLength="160" onChange={handleChange} />

      <label htmlFor="natureza">Natureza:</label>
      <select id="natureza" name="natureza" maxLength="160" onChange={handleChange} >
        <option value="">Selecione uma Natureza</option>
            {naturezaOptions.map(option => (
            <option key={option.idNatureza} value={option.idNatureza}>
                {option.natureza}
            </option>
        ))}
      </select>

      <label htmlFor="tipoAcao">Tipo de Ação:</label>
      <select id="tipoAcao" name="tipoAcao" maxLength="160" onChange={handleChange} >
        <option value="">Selecione um tipo de Ação</option>
            {tipoAcaoOptions.map(option => (
            <option key={option.idTipoAcao} value={option.idTipoAcao}>
                {option.tipoAcao}
            </option>
        ))}
      </select>

      <label htmlFor="autor">Autor:</label>
      <input type="text" id="autor" name="autor" maxLength="160" onChange={handleChange} />

      <label htmlFor="reu">Réu:</label>
      <input type="text" id="reu" name="reu" maxLength="160" onChange={handleChange} />

      <label htmlFor="funcao">Função:</label>
      <select id="funcao" name="funcao" onChange={handleChange}>
        <option value="">Selecione uma Função</option>
                {funcaoOptions.map(option => (
                <option key={option.idFuncao} value={option.idFuncao}>
                    {option.funcao}
                </option>
        ))}
      </select>

      <label htmlFor="admissao">Admissão:</label>
      <input type="date" id="admissao" name="admissao" onChange={handleChange} />

      <label htmlFor="demissao">Demissão:</label>
      <input type="date" id="demissao" name="demissao" onChange={handleChange} />

      <label htmlFor="numero_processo">Nº do Processo:</label>
      <input type="text" id="numero_processo" name="numero_processo" maxLength="80" onChange={handleChange} />

      <label htmlFor="tribunal">Tribunal Origem:</label>
      <select id="tribunal" name="tribunal" onChange={handleChange}>
        {tribunalOptions.map(option => (
          <option key={option.idTribunal} value={option.idTribunal}>{option.tribunalOrigem}</option>
        ))}
      </select>

      <label htmlFor="estado">Estado:</label>
      <select id="estado" name="estado" value={estadoSelecionado} onChange={handleEstadoChange}>
        <option value="">Selecione um estado</option>
        {estados.map(estado => (
          <option key={estado.id} value={estado.sigla}>{estado.nome}</option>
        ))}
      </select>

     <label htmlFor="cidade_origem">Cidade Origem:</label>
      <select id="cidade_origem" name="cidade_origem" value={formData.cidade_origem} onChange={handleChange}>
        <option value="">Selecione uma cidade</option>
        {cidades.map(cidade => (
          <option key={cidade.id} value={cidade.nome}>{cidade.nome}</option>
        ))}
      </select>

      <label htmlFor="data_ajuizamento">Data Ajuizamento:</label>
      <input type="date" id="data_ajuizamento" name="data_ajuizamento" onChange={handleChange} />

      <label htmlFor="principal_pedido">Principal Pedido:</label>
      <select id="principal_pedido" name="principal_pedido" onChange={handleChange}>
        {principalPedidoOptions.map(option => (
          <option key={option} value={option}>{option}</option>
        ))}
      </select>

      <label htmlFor="ultimos_andamentos">Últimos andamentos processuais:</label>
      <input type="text" id="ultimos_andamentos" name="ultimos_andamentos" maxLength="320" onChange={handleChange} />

      <label htmlFor="fase_processual">Fase Processual:</label>
      <select id="fase_processual" name="fase_processual" onChange={handleChange}>
      {faseProcessualOptions.map(option => (
          <option key={option.idTribunal} value={option.id}>{option.faseProcessual}</option>
        ))}
      </select>

      <label htmlFor="valor_causa">Valor da Causa:</label>
      <input type="number" id="valor_causa" name="valor_causa" maxLength="20" onChange={handleChange} />

      <label htmlFor="valor_perda_estimado">Valor de Perda Estimado:</label>
      <input type="number" id="valor_perda_estimado" name="valor_perda_estimado" maxLength="20" onChange={handleChange} />

      <label htmlFor="classificacao_risco">Classificação de Risco:</label>
      <select id="classificacao_risco" name="classificacao_risco" onChange={handleChange}>
      </select>

      <label htmlFor="deposito_recursal_ordinario">Depósito Recursal (Recurso Ordinário):</label>
      <input type="number" id="deposito_recursal_ordinario" name="deposito_recursal_ordinario" maxLength="20" onChange={handleChange} />

      <label htmlFor="data_deposito_recursal_ordinario">Data do Depósito Recursal (Recurso Ordinário):</label>
      <input type="date" id="data_deposito_recursal_ordinario" name="data_deposito_recursal_ordinario" onChange={handleChange} />

      <label htmlFor="deposito_recursal_revista">Depósito Recursal (Recurso Revista):</label>
      <input type="number" id="deposito_recursal_revista" name="deposito_recursal_revista" maxLength="20" onChange={handleChange} />

      <label htmlFor="data_deposito_recursal_revista">Data do Depósito Recursal (Recurso Revista):</label>
      <input type="date" id="data_deposito_recursal_revista" name="data_deposito_recursal_revista" onChange={handleChange} />

      <label htmlFor="deposito_judicial">Depósito Judicial:</label>
      <input type="number" id="deposito_judicial" name="deposito_judicial" maxLength="20" onChange={handleChange} />

      <label htmlFor="data_deposito_judicial">Data do Depósito Judicial:</label>
      <input type="date" id="data_deposito_judicial" name="data_deposito_judicial" onChange={handleChange} />

      <label htmlFor="bloqueio_judicial">Bloqueio Judicial:</label>
      <input type="number" id="bloqueio_judicial" name="bloqueio_judicial" maxLength="20" onChange={handleChange} />

      <label htmlFor="data_bloqueio_judicial">Data do Bloqueio Judicial:</label>
      <input type="date" id="data_bloqueio_judicial" name="data_bloqueio_judicial" onChange={handleChange} />

      <button type="submit">Cadastrar Processo</button>

    </form>
  );



  
};

export default CadastroProcesso;
