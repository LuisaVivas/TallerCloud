import React, { Component } from 'react';
import logo from './logo.svg';
import axios from 'axios';

class EditarEquipo extends Component {


  constructor(props){
    super(props);

    this.state = {teams: ''};
    this.handleClick = this.handleClick.bind(this);
  }


  editarEquipo(){

      var equipoNombre = document.getElementById("nombreEquipo").value;
      console.log(equipoNombre);

      var anioFu = document.getElementById("anioF").value;
      console.log(anioFu);

      var cantidad=document.getElementById("cT").value;
      console.log(cantidad);

      axios.put('http://localhost:8080/_ah/api/echo/v1/editarEquipo'+'?anioFundacion='+anioFu+'&cantidadTitulo='+cantidad+'&name='+equipoNombre)
      .then(function (response) {
      console.log(response);
    });

  }

  handleClick(event){
      event.preventDefault();
      this.editarEquipo();
  }


  render() {
    return (
      <div className="editarEquipo">
        <div className="App-header">
        <center>
          <img src={logo} className="App-logo" alt="logo" />
          <h2>Dimayor</h2> </center>
        </div>



        <form id="form1">
          <center>
          Año de fundación:<br/>
          <input type="text" name="anioFu" id="anioF"/><br/>

          Cantidad Titulo:<br/>
          <input type="text" name="cantidad" id="cT"/><br/>

          Nombre de equipo:<br/>
          <input type="text" name="nombreEquipo" id="nombreEquipo"/><br/>


          <button onClick={this.handleClick}>Editar Equipo</button>
          </center>
        </form>
      </div>
    );
  }
}


export default EditarEquipo;