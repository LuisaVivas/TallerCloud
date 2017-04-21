import React, { Component } from 'react';
import axios from 'axios';
import './App.css';
import logo from './logo.svg';


class EliminarEquipo extends Component {
 

  constructor(props){
    super(props);
    
    this.state = {
      equipos: []
    };
    this.handleClick=this.handleClick.bind(this);

  }
  eliminar(){

    var idsi= document.getElementById("Id").value;
          console.log(idsi);

    axios.get('http://localhost:8080/_ah/api/echo/v1/eliminarEquipo/'+idsi).then(res =>{
      //axios({method:'delete',url:'http://localhost:8080/_ah/api/echo/v1/eliminarEquipo/',data:{id:idsi} }).then(res=>{
           console.log(res.data);

      }

    );
  }

 handleClick(event){

  event.preventDefault();
  this.eliminar();

 }

  render(){
   return(

   <div className="App">
      <div className="App-header">
      <center>
      <img src={logo} className="App-logo" alt="logo" />
      <h2> Dimayor </h2></center>

      </div>
   

      <form action="/action_page.php">
      <center>
      Id:<br/>
      <input type="text" name="Id" id="Id"/><br/>
      <button onClick={this.handleClick}> Eliminar Equipo</button>
      </center>
      </form>



</div>

   );
   }
 }
export default EliminarEquipo;
