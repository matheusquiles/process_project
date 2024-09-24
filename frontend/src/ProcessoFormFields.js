
import React from 'react';

const ProcessoFormFields = ({ formData, handleChange, varaOptions, naturezaOptions, classificacaoRiscoOptions, escritorioOptions, funcaoOptions, tribunalOptions, tipoAcaoOptions, faseProcessualOptions, estados, cidades, estadoSelecionado, handleEstadoChange }) => {
  return (
    <>
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
      <input type="text" id="reclamada" name="reclamada" maxLength="160" onChange={handleChange} value={formData.reclamada} />

      <label htmlFor="natureza">Natureza:</label>
      <select id="natureza" name="natureza" maxLength="160" onChange={handleChange} value={formData.natureza}>
        <option value="">Selecione uma Natureza</option>
        {naturezaOptions.map(option => (
          <option key={option.idNatureza} value={option.idNatureza}>
            {option.natureza}
          </option>
        ))}
      </select>

      <label htmlFor="tipoAcao">Tipo de Ação:</label>
      <select id="tipoAcao" name="tipoAcao" maxLength="160" onChange={handleChange} value={formData.tipoAcao}>
        <option value="">Selecione um tipo de Ação</option>
        {tipoAcaoOptions.map(option => (
          <option key={option.idTipoAcao} value={option.idTipoAcao}>
            {option.tipoAcao}
          </option>
        ))}
      </select>

      <label htmlFor="vara">Vara:</label>
      <select id="vara" name="vara" maxLength="160" onChange={handleChange} value={formData.vara}>
        <option value="">Vara</option>
        {varaOptions.map(option => (
          <option key={option.idVara} value={option.idVara}>
            {option.vara}
          </option>
        ))}
      </select>


      <label htmlFor="autor">Autor:</label>
      <input type="text" id="autor" name="autor" maxLength="160" onChange={handleChange} value={formData.autor} />

      <label htmlFor="reu">Réu:</label>
      <input type="text" id="reu" name="reu" maxLength="160" onChange={handleChange} value={formData.reu} />

      <label htmlFor="funcao">Função:</label>
      <select id="funcao" name="funcao" onChange={handleChange} value={formData.funcao}>
        <option value="">Selecione uma Função</option>
        {funcaoOptions.map(option => (
          <option key={option.idFuncao} value={option.idFuncao}>
            {option.funcao}
          </option>
        ))}
      </select>

      <label htmlFor="admissao">Admissão:</label>
      <input type="date" id="admissao" name="admissao" onChange={handleChange} value={formData.admissao} />

      <label htmlFor="demissao">Demissão:</label>
      <input type="date" id="demissao" name="demissao" onChange={handleChange} value={formData.demissao} />

      <label htmlFor="numero_processo">Nº do Processo:</label>
      <input type="text" id="numero_processo" name="numero_processo" maxLength="80" onChange={handleChange} value={formData.numero_processo} />

      <label htmlFor="tribunal">Tribunal Origem:</label>
      <select id="tribunal" name="tribunal" onChange={handleChange} value={formData.tribunal}>
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
      </select>

      <label htmlFor="ultimos_andamentos_processuais">Últimos andamentos processuais:</label>
      <input type="text" id="ultimos_andamentos_processuais" name="ultimos_andamentos_processuais" maxLength="320" onChange={handleChange} />

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
      {classificacaoRiscoOptions.map(option => (
          <option key={option.idClassificacaoRisco} value={option.idClassificacaoRisco}>{option.classificacaoRisco}</option>
        ))}
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

      {/* Continue com os outros campos do formulário */}
    </>
  );
};

export default ProcessoFormFields;
