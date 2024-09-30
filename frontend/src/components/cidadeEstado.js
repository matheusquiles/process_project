import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { InputLabel, StyledSelect, InputWrapper } from '../styles/formulario';
import { GenericP } from '../styles/globalstyles';

export default function EstadoCidadeInput({ label, first, topless, imgW, small, formData, setFormData }) {
    const [estados, setEstados] = useState([]);
    const [cidades, setCidades] = useState([]);
    const [estadoSelecionado, setEstadoSelecionado] = useState(formData.estado || '');
    const [cidadeSelecionada, setCidadeSelecionada] = useState(formData.cidade || '');
    const [isLoading, setIsLoading] = useState(true);
    const [isLoadingCidades, setIsLoadingCidades] = useState(false);

    useEffect(() => {
        axios.get('https://servicodados.ibge.gov.br/api/v1/localidades/estados')
            .then(response => {
                setEstados(response.data.sort((a, b) => a.nome.localeCompare(b.nome)));
                setIsLoading(false);
            })
            .catch(error => {
                console.error('Erro ao carregar estados:', error);
                setIsLoading(false);
            });
    }, []);

    const handleEstadoChange = (e) => {
        const estadoId = e.target.value;
        const estadoNome = e.target.options[e.target.selectedIndex].text; 
        setEstadoSelecionado(estadoNome);
        setCidadeSelecionada(''); // Reset cidade quando o estado mudar
        setFormData({ ...formData, estado: estadoNome, cidade: '' }); 

        setIsLoadingCidades(true);
        axios.get(`https://servicodados.ibge.gov.br/api/v1/localidades/estados/${estadoId}/municipios`)
            .then(response => {
                setCidades(response.data.sort((a, b) => a.nome.localeCompare(b.nome)));
                setIsLoadingCidades(false);
            })
            .catch(error => {
                console.error('Erro ao carregar cidades:', error);
                setIsLoadingCidades(false);
            });
    };

    const handleCidadeChange = (e) => {
        const cidadeNome = e.target.options[e.target.selectedIndex].text; 
        setCidadeSelecionada(cidadeNome);
        setFormData({ ...formData, cidade: cidadeNome }); 
    };

    return (
        <InputWrapper>
            <InputLabel style={{ flexBasis: '30%' }} first={first} topless={topless} imgW={imgW} small={small}>
                <GenericP>{label} Estado:</GenericP>
                <StyledSelect 
                    onChange={handleEstadoChange} 
                    value={estadoSelecionado}
                    style={{ width: '100%', height: '45px' }}
                >
                    <option value="">Selecione o Estado</option>
                    {estados.map(({ id, nome }) => (
                        <option key={id} value={id}>
                            {nome}
                        </option>
                    ))}
                </StyledSelect>
            </InputLabel>

            <InputLabel style={{ flexBasis: '70%' }} first={first} topless={topless} imgW={imgW} small={small}>
                <GenericP>Cidade:</GenericP>
                <StyledSelect 
                    onChange={handleCidadeChange} 
                    value={cidadeSelecionada} 
                    disabled={!estadoSelecionado || isLoadingCidades}
                    style={{ width: '100%', height: '45px' }}
                >
                    <option value="">Selecione a Cidade</option>
                    {cidades.map(({ id, nome }) => (
                        <option key={id} value={nome}>
                            {nome}
                        </option>
                    ))}
                </StyledSelect>
            </InputLabel>
        </InputWrapper>
    );
}