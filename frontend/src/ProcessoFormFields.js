
import React from 'react';
import { NumericFormat } from 'react-number-format';
import './CadastroProcesso.css';


function ProcessoFormFields({ formData, handleChange, varaOptions, naturezaOptions, classificacaoRiscoOptions, escritorioOptions,
  funcaoOptions, tribunalOptions, tipoAcaoOptions, faseProcessualOptions, estados, cidades, estadoSelecionado, handleEstadoChange }) {
  return (
    <>
     
        <label htmlFor="admissao">Admissão:</label>
        <input type="date" id="admissao" name="admissao" onChange={handleChange} value={formData.admissao} />

        <label htmlFor="demissao">Demissão:</label>
        <input type="date" id="demissao" name="demissao" onChange={handleChange} value={formData.demissao} />


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

  
        <div id="selectedPedidosContainer">
          <label>Pedidos:</label>
          <div id="selectedPedidos"></div>
        </div>

    
        <div id="modalPedidos" class="modal">
          <div class="modal-content">
            <h2>Selecione os Pedidos</h2>
            <div id="pedidosList"></div> 
            <button id="btnAdicionar" disabled>Adicionar</button>
            <button id="btnFechar">Fechar</button>
          </div>
        </div>

        <button id="btnAddPedido" class="btn-small">Adicionar Pedido</button>

        <label htmlFor="ultimos_andamentos_processuais">Últimos andamentos processuais:</label>
        <input type="text" id="ultimos_andamentos_processuais" name="ultimos_andamentos_processuais" maxLength="320" onChange={handleChange} />


        <label htmlFor="valor_perda_estimado">Valor de Perda Estimado:</label>
        <NumericFormat
          id="valor_perda_estimado"
          name="valor_perda_estimado"
          thousandSeparator="."
          decimalSeparator=","
          prefix="R$ "
          decimalScale={2}
          fixedDecimalScale={true}
          allowNegative={false}
          maxLength="20"
          onValueChange={(values) => {
            const { value } = values;
            handleChange({ target: { name: 'valor_perda_estimado', value } });
          }}
        />



        <label htmlFor="deposito_recursal_ordinario">Depósito Recursal (Recurso Ordinário):</label>
        <NumericFormat
          id="deposito_recursal_ordinario"
          name="deposito_recursal_ordinario"
          thousandSeparator="."
          decimalSeparator=","
          prefix="R$ "
          decimalScale={2}
          fixedDecimalScale={true}
          allowNegative={false}
          maxLength="20"
          onValueChange={(values) => {
            const { value } = values;
            handleChange({ target: { name: 'deposito_recursal_ordinario', value } });
          }}
        />

        <label htmlFor="data_deposito_recursal_ordinario">Data do Depósito Recursal (Recurso Ordinário):</label>
        <input type="date" id="data_deposito_recursal_ordinario" name="data_deposito_recursal_ordinario" onChange={handleChange} />

        <label htmlFor="deposito_recursal_revista">Depósito Recursal (Recurso Revista):</label>
        <NumericFormat
          id="deposito_recursal_revista"
          name="deposito_recursal_revista"
          thousandSeparator="."
          decimalSeparator=","
          prefix="R$ "
          decimalScale={2}
          fixedDecimalScale={true}
          allowNegative={false}
          maxLength="20"
          onValueChange={(values) => {
            const { value } = values;
            handleChange({ target: { name: 'deposito_recursal_revista', value } });
          }}
        />

        <label htmlFor="data_deposito_recursal_revista">Data do Depósito Recursal (Recurso Revista):</label>
        <input type="date" id="data_deposito_recursal_revista" name="data_deposito_recursal_revista" onChange={handleChange} />

        <label htmlFor="deposito_judicial">Depósito Judicial:</label>
        <NumericFormat
          id="deposito_judicial"
          name="deposito_judicial"
          thousandSeparator="."
          decimalSeparator=","
          prefix="R$ "
          decimalScale={2}
          fixedDecimalScale={true}
          allowNegative={false}
          maxLength="20"
          onValueChange={(values) => {
            const { value } = values;
            handleChange({ target: { name: 'deposito_judicial', value } });
          }}
        />

        <label htmlFor="data_deposito_judicial">Data do Depósito Judicial:</label>
        <input type="date" id="data_deposito_judicial" name="data_deposito_judicial" onChange={handleChange} />

        <label htmlFor="bloqueio_judicial">Bloqueio Judicial:</label>
        <input type="number" id="bloqueio_judicial" name="bloqueio_judicial" maxLength="20" onChange={handleChange} />

        <label htmlFor="data_bloqueio_judicial">Data do Bloqueio Judicial:</label>
        <input type="date" id="data_bloqueio_judicial" name="data_bloqueio_judicial" onChange={handleChange} />

        {/* Continue com os outros campos do formulário */}
      
    </>


  );
}

export default ProcessoFormFields;
