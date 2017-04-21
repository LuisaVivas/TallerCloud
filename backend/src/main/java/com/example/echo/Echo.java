
/*
 * Copyright (c) 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not  use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.example.echo;

import beans.Equipo;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.response.BadRequestException;

import java.util.ArrayList;
import java.util.List;

/**
 * The Echo API which Endpoints will be exposing.
 */
// [START echo_api_annotation]
@Api(
        name = "echo",
        version = "v1"
// [END_EXCLUDE]
)
// [END echo_api_annotation]
public class Echo {

    /**
     * Echoes the received message back. If n is a non-negative integer, the
     * message is copied that many times in the returned message.
     *
     * Note that name is specified and will override the default name of "{class
     * name}.{method name}". For example, the default is "echo.echo".
     *
     * Note that httpMethod is not specified. This will default to a reasonable
     * HTTP method depending on the API method name. In this case, the HTTP
     * method will default to POST.
     */
    // [START echo_method]
    private Dimayor dima;

    @ApiMethod(name = "getEquipos", httpMethod = ApiMethod.HttpMethod.GET)
    public List<Equipo> getEquipos() {

        if (dima == null) {
            dima = new Dimayor();
        }
        return dima.getEquipos();
    }

    @ApiMethod(name = "infoEquipo", httpMethod = ApiMethod.HttpMethod.GET)
    public Equipo infoEquipo(@Named("id") int id) {
        if (dima == null) {
            dima = new Dimayor();
        }
        Equipo e = dima.infoEquipo(id);
        return e;
    }

    @ApiMethod(name = "eliminarEquipo", httpMethod = ApiMethod.HttpMethod.DELETE)
    public void eliminarEquipo(@Named("id") int idEquipo) throws BadRequestException {
        if (dima == null) {
            dima = new Dimayor();
        }
        dima.eliminarEquipo(idEquipo);
    }

    @ApiMethod(httpMethod = ApiMethod.HttpMethod.PUT, name = "editarEquipo", path = "editarEquipo")
    public void editarEquipo(@Named("name") String name, @Named("anioFundacion") int anioFundacion, @Named("cantidadTitulo") int cantidadTitulo) {
        if (dima == null) {
            dima = new Dimayor();
        }
        dima.cambiarInfoEquipo(name, anioFundacion, cantidadTitulo);
    }

    @ApiMethod(httpMethod = ApiMethod.HttpMethod.POST, name = "agregarEquipo", path = "agregarEquipo")
    public Equipo agregarEquipo(@Named("id") int id, @Named("name") String name, @Named("anioFundacion") int anioFundacion, @Named("cantidadTitulo") int cantidadTitulo) {
        if (dima == null) {
            dima = new Dimayor();
        }
        return dima.agregarNuevoEquipo(id, name, anioFundacion, cantidadTitulo);

    }
}
