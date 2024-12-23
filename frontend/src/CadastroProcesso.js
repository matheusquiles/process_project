
import React, { useEffect } from 'react';
import { setLoading, setFormData, setInvalidFields, setSelectedPedidos, resetForm, setUpdating } from './redux/reducers/formSlice';
import { useDispatch, useSelector } from 'react-redux';
import axios from 'axios';
import Input from './components/input.js';
import SelectRest from './components/selectRest.js';
import DateImput from './components/date.js';
import MoneyImput from './components/money.js';
import * as F from './styles/formulario.jsx';
import EstadoCidadeInput from './components/cidadeEstado.js';
import MultiSelectRest from './components/multiSelectRest.js';
import { API_BASE_URL } from './helpers/constants.js';
import { API_SAVE_URL } from './helpers/constants.js';
import camelCase from './helpers/camelCase.js';

import { CssVarsProvider } from '@mui/joy/styles';
import CssBaseline from '@mui/joy/CssBaseline';
import Box from '@mui/joy/Box';
import Breadcrumbs from '@mui/joy/Breadcrumbs';
import Link from '@mui/joy/Link';
import Typography from '@mui/joy/Typography';
import Button from '@mui/joy/Button';

import HomeRoundedIcon from '@mui/icons-material/HomeRounded';
import ChevronRightRoundedIcon from '@mui/icons-material/ChevronRightRounded';
import CircularProgress from '@mui/joy/CircularProgress';

const CadastroProcesso = () => {
  const dispatch = useDispatch();
  const loading = useSelector((state) => state.form.loading);
  const formData = useSelector((state) => state.form.formData);
  const invalidFields = useSelector((state) => state.form.invalidFields);
  const selectedPedidos = useSelector((state) => state.form.selectedPedidos);
  const errorMessage = useSelector((state) => state.form.errorMessage);
  const isLoading = useSelector((state) => state.form.isLoading);
  const isUpdating = useSelector((state) => state.form.isUpdating);

  useEffect(() => {
    dispatch(resetForm());
  }, [dispatch]);

  const handleChange = (e) => {
    if (e.target && e.target.name && e.target.value !== undefined) {
      const { name, value } = e.target;
      dispatch(setFormData({ [name]: value }));
    } else {
      console.error('Event target is missing name or value:', e.target);
    }
  };

  const handleMultiSelectChange = (selectedItems) => {

    if (!Array.isArray(selectedItems)) {
      selectedItems = [];
    }

    const mappedItems = selectedItems.map(item => ({
      tipoPedido: item.id
    }));

    setSelectedPedidos(mappedItems);
    dispatch(setSelectedPedidos(mappedItems));
  };


  const validateFields = () => {
    const requiredFields = ['numeroProcesso', 'autor', 'reu', 'reclamada', 'escritorio', 'faseProcessual', 'classificacaoRisco',
      'natureza', 'tipoAcao', 'tribunal', 'vara', 'funcao'];
    const invalids = requiredFields.filter(field => !formData[field] || formData[field] === '');
    dispatch(setInvalidFields(invalids));
    return invalids.length === 0;
  };


  const handleSubmit = async (e) => {
    e.preventDefault();
    dispatch(setUpdating(true));
    
    if (validateFields()) {
      try {
        const camelCaseFormData = camelCase.convertKeysToCamelCase(formData);
        const dataToSend = {
          ...camelCaseFormData,
          pedido: selectedPedidos
        };

        console.log("Dados a serem enviados:", JSON.stringify(dataToSend, null, 2));
        const response = await axios.post(`${API_SAVE_URL}`, dataToSend);
        await new Promise((resolve) => setTimeout(resolve, 3000));

        if (response.data === true) {
          alert('Processo criado com sucesso!');
        } else {
          alert('Já existe um processo com esse número.');
        }

      } catch (error) {
        console.error('Erro ao criar o processo:', error);

        if (error.response) {
          alert(`Erro ao criar o processo: ${error.response.data.message || 'Erro desconhecido'}`);
        } else if (error.request) {
          alert('Erro: Nenhuma resposta recebida do servidor.');
        } else {
          alert(`Erro ao configurar a requisição: ${error.message}`);
        }
      } finally {
        dispatch(setUpdating(false));
      }
    } else {
      alert('Por favor, preencha todos os campos obrigatórios.');
      dispatch(setUpdating(false));
    }
  };

  const handleCancelClick = () => {
    dispatch(resetForm());
  };



  return (
    <>
      <form onSubmit={handleSubmit} className="cadastro-processo-form">
        <CssVarsProvider disableTransitionOnChange>
          <CssBaseline />
          <Box sx={{ display: 'flex', minHeight: '100dvh' }}>
            <Box
              component="main"
              className="MainContent"
              sx={{
                px: { xs: 2, md: 6 },
                pt: {
                  xs: 'calc(12px + var(--Header-height))',
                  sm: 'calc(12px + var(--Header-height))',
                  md: 3,
                },
                pb: { xs: 2, sm: 2, md: 3 },
                flex: 1,
                display: 'flex',
                flexDirection: 'column',
                minWidth: 0,
                height: '100dvh',
                gap: 1,
              }}
            >
              <Box sx={{ display: 'flex', alignItems: 'center' }}>
                <Breadcrumbs
                  size="sm"
                  aria-label="breadcrumbs"
                  separator={<ChevronRightRoundedIcon fontSize="sm" />}
                  sx={{ pl: 0 }}
                >
                  <Link
                    underline="none"
                    color="neutral"
                    aria-label="Home"
                  >
                    <HomeRoundedIcon />
                  </Link>
                  <Link
                    underline="hover"
                    color="neutral"
                    sx={{ fontSize: 12, fontWeight: 500 }}
                  >
                    Processos
                  </Link>
                  <Typography color="primary" sx={{ fontWeight: 500, fontSize: 12 }}>
                    Novo Processo
                  </Typography>
                </Breadcrumbs>
              </Box>
              <Box
                sx={{
                  display: 'flex',
                  mb: 1,
                  gap: 1,
                  flexDirection: { xs: 'column', sm: 'row' },
                  alignItems: { xs: 'start', sm: 'center' },
                  flexWrap: 'wrap',
                  justifyContent: 'space-between',
                }}
              >
                <Typography level="h2" component="h1">
                  Novo Processo
                </Typography>
              </Box>
              <F.InputLine column>
                <F.InputLine>
                  <SelectRest
                    label="Escritório"
                    first route='escritorio'
                    id='idEscritorio'
                    name='nomeEscritorio'
                    onChange={handleChange}
                    form={formData}
                    defaultValue=""
                    invalidFields={invalidFields}
                    loading={loading}
                  />
                  <Input
                    label="Nº do Processo"
                    fieldName="numeroProcesso"
                    formData={formData}
                    setFormData={setFormData}
                    onChange={handleChange}
                    invalidFields={invalidFields}
                  />
                  <Input
                    label="Réu"
                    fieldName="reu"
                    formData={formData}
                    setFormData={setFormData}
                    onChange={handleChange}
                  />
                </F.InputLine>

                <F.InputLine>
                  <SelectRest
                    label="Fase Processual"
                    first medium route='faseProcessual'
                    id='idFaseProcessual'
                    name='faseProcessual'
                    onChange={setFormData}
                    defaultValue=""
                    form={formData}
                    invalidFields={invalidFields}
                    loading={loading}
                  />
                  <Input
                    label="Autor"
                    fieldName="autor"
                    formData={formData}
                    setFormData={setFormData}
                    onChange={handleChange}
                    invalidFields={invalidFields}
                  />
                  <Input
                    label="Reclamada"
                    fieldName="reclamada"
                    formData={formData}
                    setFormData={setFormData}
                    onChange={handleChange}
                  />
                </F.InputLine>

                <F.InputLine>
                  <SelectRest
                    label="Vara"
                    first medium route='vara'
                    id='idVara'
                    name='vara'
                    onChange={setFormData}
                    form={formData}
                    defaultValue=""
                    invalidFields={invalidFields}
                    loading={loading}
                  />
                  <SelectRest
                    label="Classificação de Risco"
                    medium route='classificacaoRisco'
                    id='idClassificacaoRisco'
                    name='classificacaoRisco'
                    onChange={setFormData}
                    form={formData}
                    defaultValue=""
                    invalidFields={invalidFields}
                    loading={loading}
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
                    loading={loading}
                  />
                </F.InputLine>

                <F.MediumInputLine>
                  <SelectRest
                    label="Natureza"
                    first imgW route='natureza'
                    id='idNatureza'
                    name='natureza'
                    onChange={setFormData}
                    form={formData}
                    defaultValue=""
                    invalidFields={invalidFields}
                    loading={loading}
                  />
                  <SelectRest
                    label="Tipo de Ação"
                    route='tipoAcao'
                    id='idTipoAcao'
                    name='tipoAcao'
                    onChange={setFormData}
                    form={formData}
                    defaultValue=""
                    invalidFields={invalidFields}
                    loading={loading}
                  />
                </F.MediumInputLine>

                <F.MediumInputLine>
                  <SelectRest
                    label="Tribunal Origem"
                    first route='tribunal'
                    id='idTribunal'
                    name='tribunalOrigem'
                    onChange={setFormData}
                    form={formData}
                    defaultValue=""
                    invalidFields={invalidFields}
                    loading={loading}
                  />
                  <DateImput
                    label="Data de Ajuizamento"
                    small
                    fieldName="dataAjuizamento"
                    value={formData.dataAjuizamento || ''}
                    setFormData={setFormData}
                    onChange={handleChange}
                  />
                  <MoneyImput
                    label="Valor da Causa"
                    imgW fieldName="valorCausa"
                    formData={formData}
                    setFormData={setFormData}
                    onChange={handleChange} />
                </F.MediumInputLine>

                <F.MediumInputLine>
                  <EstadoCidadeInput
                    label="Estado"
                    first
                    formData={formData}
                    setFormData={setFormData}
                    onChange={handleChange}
                  />
                </F.MediumInputLine>

                <F.MediumInputLine>
                  <Input
                    label="Últimos andamentos processuais"
                    first fieldName="ultimosAndamentosProcessuais"
                    formData={formData}
                    setFormData={setFormData}
                    onChange={handleChange}
                    invalidFields={invalidFields}
                  />
                </F.MediumInputLine>

                <F.MediumInputLine>
                  <MultiSelectRest
                    label="Pedidos do Processo"
                    first route='tipoPedido'
                    id='idTipoPedido'
                    name='descricao'
                    onChange={handleMultiSelectChange}
                    form={formData}
                    defaultValue={[]}
                    invalidFields={invalidFields}
                    loading={loading}
                  />
                </F.MediumInputLine>

                <F.SmallInputLine>
                  <DateImput
                    label="Data Admissão"
                    fieldName="admissao"
                    first formData={formData}
                    value={formData.admissao || ''}
                    setFormData={setFormData}
                    onChange={handleChange}
                  />
                  <DateImput
                    label="Data Demissão"
                    fieldName="demissao"
                    value={formData.demissao || ''}
                    formData={formData}
                    setFormData={setFormData}
                    onChange={handleChange}
                  />
                </F.SmallInputLine>

                <F.SmallInputLine>
                  <MoneyImput
                    label="Depósito Recurso Ordinário"
                    first fieldName="depositoRecursalOrdinario"
                    formData={formData}
                    setFormData={setFormData}
                    onChange={handleChange}
                  />
                  <DateImput
                    label="Data Recurso Ordinário"
                    fieldName="dataDepositoRecursalOrdinario"
                    formData={formData}
                    value={formData.dataDepositoRecursalOrdinario || ''}
                    setFormData={setFormData}
                    onChange={handleChange}
                  />
                </F.SmallInputLine>

                <F.SmallInputLine>
                  <MoneyImput
                    label="Depósito Recurso Revista"
                    first fieldName="depositoRecursalRevista"
                    formData={formData}
                    setFormData={setFormData}
                    onChange={handleChange}
                  />
                  <DateImput
                    label="Data Recurso Revista"
                    fieldName="dataDepositoRecursalRevista"
                    formData={formData}
                    value={formData.dataDepositoRecursalRevista || ''}
                    setFormData={setFormData}
                    onChange={handleChange}
                  />
                </F.SmallInputLine>

                <F.SmallInputLine>
                  <MoneyImput
                    label="Depósito Judicial"
                    first fieldName="depositoJudicial"
                    formData={formData}
                    setFormData={setFormData}
                    onChange={handleChange}
                  />
                  <DateImput
                    label="Data do Depósito Judicial"
                    fieldName="dataDepositoJudicial"
                    formData={formData}
                    value={formData.dataDepositoJudicial || ''}
                    setFormData={setFormData}
                    onChange={handleChange}
                  />
                </F.SmallInputLine>

              </F.InputLine>

            </Box>
          </Box>

          <F.InputLine>
            <Box sx={{
              display: 'flex',
              flexWrap: 'nowrap',
              gap: 2,
              mt: 15,
              mb: 1,
              width: '100%',
              paddingBottom: '30px',
              overflow: 'visible', 
              flexDirection: 'row',
              alignItems: 'flex-start',
              justifyContent: 'flex-end'
            }}>
              <Button type="button" variant='outlined' onClick={handleCancelClick}>Cancelar</Button>
              <Button type="submit" onClick={handleSubmit} disabled={isUpdating} startDecorator={isUpdating ? <CircularProgress variant="solid" /> : null}>
                {isUpdating ? 'Cadastrando...' : 'Cadastrar Processo'}
              </Button>
            </Box>
          </F.InputLine>

        </CssVarsProvider>


        {errorMessage && <p style={{ color: 'red' }}>{errorMessage}</p>} {/* Exibir mensagem de erro */}


      </form >
    </>
  );
};
export default CadastroProcesso;
