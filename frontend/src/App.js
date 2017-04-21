//autor Luisa
import React, { Component } from 'react';
import axios from 'axios';
import logo from './logo.svg';
import './App.css';


class App extends Component {
 

  constructor(props){
    super(props);
    
    this.state = {
      equipos: []
    };

  }

  componentDidMount(){
    axios.get('http://localhost:8080/_ah/api/echo/v1/equipocollection').then(res =>{

      console.log(res);
      console.log(res.data.items);
      const equipos=res.data.items.map(obj => obj);
      this.setState({ equipos});
    });
  }
  render(){
    return(
      <div className="App">
      <div className="App-header">
      <center>
      <img src={logo} className="App-logo" alt="logo" />
      <h2> Dimayor </h2></center>

      </div>

      <div> 
      <center>
         <ul>
         {this.state.equipos.map( equipo => 
          <li key={equipo.idEquipo}>{equipo.nombre}</li>
         )}
        </ul></center>


      </div>

    </div>
    
  );       

 }

}
export default App;
