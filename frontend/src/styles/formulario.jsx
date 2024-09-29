import styled from 'styled-components';
// import { PRIMARY, SECUNDARY, SECUNDARY_DISABLED, WHITE } from './colors';
import { WHITE, TEXT_SECUNDARY, BOX_SHADOW, BACKGROUND, HR } from './colors';

const MARGIN = '0.5em';

export const Input = styled.input`
  background-color: ${ WHITE };
  border: solid ${ TEXT_SECUNDARY } .1px;
  border-radius: 5px;
  /* margin: ${ MARGIN} 0; */
  /* font-size: 0.7em; */
  padding: 1em;
  box-shadow: ${ BOX_SHADOW };
  outline: none;
`;

export const InputLine = styled.div`
  width: 100%;
  display: flex;
  flex-direction: ${ ({ column }) => column ? 'column' : 'row' };
  align-items: flex-start;
`

export const SmallInputLine = styled(InputLine)`
  margin-right: 1rem;
  max-width: calc(37.5% - 1rem);
`

export const InputLabel = styled.label`
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  justify-content: space-around;
  margin-left: ${ ({ first, small }) => first ? 0 : small ? '.5rem' : '1rem' };
  margin-right: ${ ({ first, small }) => first && small ? '.5rem' : '0' };
  width: ${ ({ imgW }) => imgW ? '25%' : 'auto' };
  flex-grow: ${ ({ imgW, small }) => imgW || small ? 0 : 1 };
  /* color: ${ TEXT_SECUNDARY }; */

  /* @media(min-width: 1280px) {
    margin-left: ${ ({ gap }) => gap ? '1rem' : '0' };
    width: ${ ({ items }) => !items || items < 2 ? '100%' : `calc(100% / ${ items })` };
    max-width: ${ ({ maxWidth }) => maxWidth && maxWidth};
    padding: ${ ({ pad, maxWidth }) => pad && `0 calc((100% - ${ maxWidth }) / 2)`};
  } */
`;

export const LogoLine = styled.div`
  width: 100%;
  height: 180px;
  display: flex;
  flex-direction: row;
  align-items: center;
`

export const Logo = styled.img`
  /* height: 100%; */
  width: 25%;
  margin-left: 1rem;
  /* border-radius: 50%; */
  cursor: pointer;
`;

export const StyledSelect = styled.select`
  color: ${ TEXT_SECUNDARY };
  box-shadow: none;
  outline: none;
  cursor: pointer;
  width: 100%;
  border-radius: 5px;
  text-align: center;
  background-color: ${ ({ $styled }) => !$styled && BACKGROUND };
  line-height: 2rem;
  font-size: 0.91rem;
  padding: 0.5rem 0;
  height: 100%;
  border:  ${ ({ $styled }) => $styled && `solid ${ HR } 1px` };
  border-right: ${ ({ $styled }) => !$styled && 'solid transparent 0.5rem' };
  overflow-y: scroll;

  :focus {
    background-color:  ${ ({ $styled }) => !$styled && WHITE };
    box-shadow:  ${ ({ $styled }) => !$styled && BOX_SHADOW };
  }

  :disabled {
    background-color: ${ BACKGROUND };
    border: solid ${ BACKGROUND } 1px;
    opacity: 0.7;
  }

  ::-webkit-inner-spin-button {
    -webkit-appearance: none;
  }
`;