import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Input from './components/input.js'
import SelectRest from './components/selectRest.js'
import * as F from './styles/formulario.jsx'
import ProcessoFormFields from './ProcessoFormFields';  // Importando o novo componente

const CadastroProcesso = () => {
  const [naturezaOptions, setNaturezaOptions] = useState([]);
  const [principalPedidoOptions, setPrincipalPedidoOptions] = useState([]);
  const [tribunalOptions, setTribunalOptions] = useState([]);
  const [escritorioOptions, setEscritorioOptions] = useState([]);
  const [funcaoOptions, setFuncaoOptions] = useState([]);
  const [faseProcessualOptions, setFaseProcessualOptions] = useState([]);
  const [tipoAcaoOptions, setTipoAcaoOptions] = useState([]);
  const [classificacaoRiscoOptions, setClassificacaoRiscoOptions] = useState([]);
  const [varaOptions, setVaraOptions] = useState([]);
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
    vara: '',
    principal_pedido: '',
    ultimos_andamentos_processuais: '',
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

  useEffect(() => {
    axios.get(`${apiBaseUrl}tribunal`).then(response => setTribunalOptions(response.data));
    axios.get(`${apiBaseUrl}escritorio`).then(response => setEscritorioOptions(response.data));
    axios.get(`${apiBaseUrl}natureza`).then(response => setNaturezaOptions(response.data));
    axios.get(`${apiBaseUrl}funcao`).then(response => setFuncaoOptions(response.data));
    axios.get(`${apiBaseUrl}vara`).then(response => setVaraOptions(response.data));
    axios.get(`${apiBaseUrl}classificacaoRisco`).then(response => setClassificacaoRiscoOptions(response.data));
    axios.get('https://servicodados.ibge.gov.br/api/v1/localidades/estados').then(response => {
      setEstados(response.data.sort((a, b) => a.nome.localeCompare(b.nome)));
    });
    axios.get(`${apiBaseUrl}faseProcessual`).then(response => setFaseProcessualOptions(response.data));
    axios.get(`${apiBaseUrl}tipoAcao`).then(response => setTipoAcaoOptions(response.data));
  }, []);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prevState => ({
      ...prevState,
      [name]: value
    }));
  };

  const handleEstadoChange = (e) => {
    const estadoId = e.target.value;
    setEstadoSelecionado(estadoId);
    setFormData({ ...formData, estado: estadoId });

    axios.get(`https://servicodados.ibge.gov.br/api/v1/localidades/estados/${estadoId}/municipios`).then(response => {
      setCidades(response.data);
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const camelCaseFormData = convertKeysToCamelCase(formData);
    axios.post(`${apiBaseUrl}processo/salvar`, camelCaseFormData)
      .then(response => console.log('Processo criado com sucesso!', response.data))
      .catch(error => console.error('Erro ao criar o processo:', error));
  };

  useEffect(() => {
    // Função para fechar o modal
    const btnFechar = document.getElementById('btnFechar');
    if (btnFechar) {
      btnFechar.addEventListener('click', function () {
        document.getElementById('modalPedidos').style.display = 'none';
      });
    }

    // Função para carregar valores da API
    function loadTipoPedidosFromAPI() {
      axios.get(`${apiBaseUrl}tipoPedido`).then(response => {
        const data = response.data;

        const checkboxContainer = document.getElementById('checkbox-container');
        checkboxContainer.innerHTML = '';

        data.forEach(tipoPedido => {
          const checkbox = document.createElement('input');
          checkbox.type = 'checkbox';
          checkbox.value = tipoPedido.idTipoPedido;
          checkbox.id = `tipoPedido-${tipoPedido.idTipoPedido}`;

          const label = document.createElement('label');
          label.htmlFor = `tipoPedido-${tipoPedido.idTipoPedido}`;
          label.innerText = tipoPedido.descricao;

          const div = document.createElement('div');
          div.appendChild(checkbox);
          div.appendChild(label);

          checkboxContainer.appendChild(div);
        });

        // Reativar o botão de adicionar se um tipo de pedido for selecionado
        const checkboxes = document.querySelectorAll('#checkbox-container input[type="checkbox"]');
        checkboxes.forEach(checkbox => {
          checkbox.addEventListener('change', () => {
            const adicionarBtn = document.getElementById('add-btn');
            adicionarBtn.disabled = !Array.from(checkboxes).some(chk => chk.checked);
          });
        });
      })
        .catch(error => {
          console.error('Erro ao carregar os tipos de pedido:', error);
        });
    }

    // Função para abrir o modal
    const btnAddPedido = document.getElementById('btnAddPedido');
    if (btnAddPedido) {
      btnAddPedido.addEventListener('click', function () {
        document.getElementById('modalPedidos').style.display = 'block';
        loadTipoPedidosFromAPI(); // Carrega os pedidos da API
      });
    }

    // Função para adicionar pedidos selecionados
    const btnAdicionar = document.getElementById('btnAdicionar');
    if (btnAdicionar) {
      btnAdicionar.addEventListener('click', function () {
        const selectedPedidos = [];
        const checkboxes = document.querySelectorAll('#pedidosList input[type="checkbox"]:checked');

        checkboxes.forEach(checkbox => {
          selectedPedidos.push(checkbox.value);
        });

        // Exibe os pedidos selecionados na página principal
        const selectedPedidosDiv = document.getElementById('selectedPedidos');
        selectedPedidosDiv.innerHTML = selectedPedidos.join(', ');

        // Fecha o modal
        document.getElementById('modalPedidos').style.display = 'none';
      });
    }
  }, []);

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
              onChange={ setFormData }
            />
            <Input label="Nº do Processo" value={ formData.escritorio } />
          </F.InputLine>

          <F.InputLine topless>
            <Input label="Autor" first />
            <Input label="Fase Processual" />
          </F.InputLine>
        </F.InputLine>

        <F.Logo src='/images/logo.jpg' alt='Logo' />
      </F.LogoLine>

      <F.InputLine>
        <Input label="Réu" first />
        <Input label="Reclamada" />
        <Input label="Classificação de Risco" imgW />
      </F.InputLine>

      <F.InputLine>
        <F.SmallInputLine>
          <Input label="Natureza" first small />
          <Input label="Tipo de Ação" small />
        </F.SmallInputLine>
        <F.SmallInputLine>
          <Input label="Tribunal de Origem" first small />
          <Input label="Data de Ajuizamento" small />
        </F.SmallInputLine>
        <Input label="Valor da Causa" first imgW />
      </F.InputLine>

      <ProcessoFormFields
        formData={formData}
        handleChange={handleChange}
        naturezaOptions={naturezaOptions}
        escritorioOptions={escritorioOptions}
        funcaoOptions={funcaoOptions}
        tribunalOptions={tribunalOptions}
        tipoAcaoOptions={tipoAcaoOptions}
        faseProcessualOptions={faseProcessualOptions}
        varaOptions={varaOptions}
        estados={estados}
        cidades={cidades}
        estadoSelecionado={estadoSelecionado}
        classificacaoRiscoOptions={classificacaoRiscoOptions}
        handleEstadoChange={handleEstadoChange}
      />

      {/* Outros campos e botão de envio */}
      <button type="submit">Cadastrar Processo</button>
    </form>
  );
};

export default CadastroProcesso;
