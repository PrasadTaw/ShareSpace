import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Nav, Navbar, NavDropdown } from 'react-bootstrap';
import { Routes, Route, Navigate, Link } from 'react-router-dom'

import About from './About';
import Login from './Login';
import URegister from '../UserComponent/URegister';
import ERegister from '../ListerComponent/ERegister';



export default function NavbarComponent() {
  const alinkStyle = {
    fontSize: '30px',
    marginLeft: '10px',
    marginRight: 'auto',
    fontWeight: 'bold',
  };

  const navLinkStyle = {
    fontSize: '20px',
  };

  return (
    <div>
      <Navbar bg="danger" variant="dark">
        <Navbar.Brand style={alinkStyle} className="text-white">
          ShareSpace
        </Navbar.Brand>
        <Nav className="ml-auto">
          <NavDropdown title="Register" id="basic-nav-dropdown" className="text-white" style={navLinkStyle}>
            <NavDropdown.Item href="/uregister" >Lister</NavDropdown.Item>
            <NavDropdown.Item href="/eregister">Seeker</NavDropdown.Item>
          </NavDropdown>
          
          <Nav.Link className="text-white" href="/login" style={navLinkStyle}>
            Login
          </Nav.Link>
          
          <Nav.Link className="text-white" href="/about" style={navLinkStyle}>
            About us
          </Nav.Link>
        </Nav>
      </Navbar>
    </div>
  );
}
