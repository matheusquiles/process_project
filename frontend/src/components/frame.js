import React from 'react';
import styled from 'styled-components';

const FrameWrapper = styled.div`
  display: flex;
  flex-direction: column;
  min-height: 100vh;
`;

const Header = styled.header`
  background-color: #f5f5f5;
  padding: 1rem;
  display: flex;
  align-items: center;
  justify-content: space-between;
`;

const Menu = styled.nav`
  ul {
    list-style: none;
    display: flex;
    gap: 1rem;
    margin-right: auto; /* Menu alinhado à esquerda */
  }
`;

const Logo = styled.img`
  height: 60px;
  margin-left: auto; /* Logo alinhado à direita */
`;

const Content = styled.main`
  flex: 1;
  padding: 2rem;
`;

const Footer = styled.footer`
  background-color: #f5f5f5;
  padding: 1rem;
  text-align: center;
`;

const Frame = ({ children }) => {
  return (
    <FrameWrapper>
      <Header>
        <Menu>
          <ul>
            <li>Home</li>
            <li>About</li>
            <li>Contact</li>
          </ul>
        </Menu>
        <Logo src="/images/logo.png" alt="Logo" />
      </Header>
      <Content>
        {children}
      </Content>
      <Footer>
        <p>© 2024 Shopia Softwares</p>
      </Footer>
    </FrameWrapper>
  );
};

export default Frame;
