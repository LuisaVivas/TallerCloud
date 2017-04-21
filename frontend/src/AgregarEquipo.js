import React, { Component } from 'react';
import logo from './logo.svg';
import axios from 'axios';

class AgregarEquipo extends Component {


  constructor(props){
    super(props);

    this.state = {teams: ''};
    this.handleClick = this.handleClick.bind(this);
  }

  agregarEquipo(){

      var equipoNombre = document.getElementById("nombreEquipo").value;
      console.log(equipoNombre);

      var anioFu = document.getElementById("anioF").value;
      console.log(anioFu);

      var cantidad=document.getElementById("cT").value;
      console.log(cantidad);

      var idsi=document.getElementById("id").value;
      console.log(idsi);

      axios.post('http://localhost:8080/_ah/api/echo/v1/agregarEquipo'+'?anioFundacion='+anioFu+'&cantidadTitulo='+cantidad+'&id='+idsi+'&name='+equipoNombre)
      .then(function (response) {
      console.log(response);
    });


  }

  handleClick(event){
      event.preventDefault();
      this.agregarEquipo();
  }


  render() {
    return (

      <div className="editarEquipo">
        <div className="App-header">
          <center>
          <img src={logo} className="App-logo" alt="logo" />
          <h2>Dimayor</h2></center>
        </div>


          <form id="form1"> 
          <center>
          Año de fundación:<br/>
          <input type="text" name="anioFu" id="anioF"/><br/>

          Cantidad Titulo:<br/>
          <input type="text" name="cantidad" id="cT"/><br/>

          ID:<br/>
          <input type="text" name="idsi" id="id"/><br/>

          Nombre de equipo:<br/>
          <input type="text" name="nombreEquipo" id="nombreEquipo"/><br/>

          <button onClick={this.handleClick}>Agregar Equipo</button>
          </center>
        </form>
      </div>
    );
  }
}
export default AgregarEquipo;