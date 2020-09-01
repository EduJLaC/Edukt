package com.fisi.disoft.controlador.desktop;

import com.fisi.disoft.modelo.dao.DAOFactory;
import com.fisi.disoft.modelo.dao.entity.Productor;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    VBox vBox;
    TextArea resultado;

    DAOFactory daoRelacional;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        resultado = new TextArea();
        resultado.setPrefHeight(350);
        daoRelacional = DAOFactory.getDAOFactory(DAOFactory.Relacional);
    }

    private void limpiar() {
        resultado.clear();
        vBox.getChildren().clear();
    }

    private void opciones(HBox hBox, String opc1, String opc2, TextField... fields) {

        vBox.getChildren().clear();

        hBox.getChildren().add(new Label(opc1));
        hBox.getChildren().add(fields[0]);
        hBox.getChildren().add(new Label(opc2));
        hBox.getChildren().add(fields[1]);
    }

    @FXML
    public void pregunta1() {
        limpiar();

        HBox hBox = new HBox();
        hBox.setSpacing(10);

        TextField region = new TextField();
        TextField botellas = new TextField();
        opciones(hBox, "Region", "Cantidad de botellas", region, botellas);

        Button consulta = new Button("consulta");

        consulta.setOnAction(event -> {
            resultado.clear();
            List<Productor> productores =
                    daoRelacional
                    .getProductorDAO()
                    .productoresDeRegionPorProduccionMayorA(region.getText().trim(),
                            Integer.parseInt(botellas.getText().trim()));

            resultado.appendText("\tNombre \t\t\t Apellido"+ "\n");
            for (Productor p: productores) {
                resultado.appendText("\t" + p.getNombre() + "\t\t" + p.getApellido() + "\n");
            }
        });

        hBox.getChildren().add(consulta);

        vBox.getChildren().add(hBox);
        vBox.getChildren().add(resultado);
    }

    @FXML
    public void pregunta2() {
        limpiar();

        HBox hBox = new HBox();
        hBox.setSpacing(10);

        TextField grado = new TextField();
        TextField productor = new TextField();
        opciones(hBox, "Grado", "Id del productor", grado, productor);

        Button consulta = new Button("consulta");

        consulta.setOnAction(event -> {
            resultado.clear();
            List<Integer> vinos =
                    daoRelacional
                    .getVinoDAO()
                    .vinoConGradoSuperiorProducidoPor(
                            Integer.parseInt(grado.getText().trim()),
                            Integer.parseInt(productor.getText().trim())
                    );

            resultado.appendText("\tID Vino"+ "\n");
            for (int vino : vinos) {
                resultado.appendText(vino + "\n");
            }
        });

        hBox.getChildren().add(consulta);

        vBox.getChildren().add(hBox);
        vBox.getChildren().add(resultado);
    }

    @FXML
    public void pregunta3() {
        limpiar();

        List<Productor> productores = daoRelacional.getProductorDAO().productoresSinProduccion();
        resultado.appendText("ID \t\t Nombre \t\t Apellido \n");

        for (Productor productor: productores) {
            resultado.appendText(productor.getIdProductor() + "\t" +
                    productor.getNombre() + "\t" + productor.getApellido() + "\n");
        }

        vBox.getChildren().add(resultado);
    }

    @FXML
    public void pregunta4() {
        limpiar();

        List<Integer> vinos = daoRelacional.getVinoDAO().idVinoProducidoEnMayorCantidad();
        resultado.appendText("ID Vino \n");

        for (int vino: vinos) {
            resultado.appendText(vino + "\n");
        }

        vBox.getChildren().add(resultado);
    }

    @FXML
    public void pregunta5() {
        limpiar();

        HBox hBox = new HBox();
        TextField cantidad = new TextField();
        hBox.getChildren().add(new Label("Cantidad de vinos"));
        hBox.getChildren().add(cantidad);

        Button consulta = new Button("consulta");

        consulta.setOnAction(event -> {
            resultado.clear();
            List<Productor> productores = daoRelacional.getProductorDAO()
                    .productoresQueProducenALoMasVinos(Integer.parseInt(cantidad.getText().trim()));
            resultado.appendText("Nombre \t\t Apellido \n");

            for (Productor productor: productores) {
                resultado.appendText(productor.getNombre() + "\t" + productor.getApellido() + "\n");
            }
        });

        hBox.getChildren().add(consulta);
        vBox.getChildren().add(hBox);
        vBox.getChildren().add(resultado);
    }

    @FXML
    public void pregunta6(){
        limpiar();

        HBox hBox = new HBox();
        TextField botellas = new TextField();
        hBox.getChildren().add(new Label("Botellas producidas"));
        hBox.getChildren().add(botellas);

        Button consulta = new Button("consulta");

        consulta.setOnAction(event -> {
            resultado.clear();
            int productores = daoRelacional.getVinoDAO()  // TODO fix
                    .mostrarVinosSignificativos(Integer.parseInt(botellas.getText().trim()));
            resultado.appendText("Nombre \t\t Apellido \n");

        });

        hBox.getChildren().add(consulta);
        vBox.getChildren().add(hBox);
        vBox.getChildren().add(resultado);
    }

    @FXML
    public void pregunta7(){
        limpiar();

        HBox hBox = new HBox();
        TextField productorId = new TextField();
        hBox.getChildren().add(new Label("ID del productor"));
        hBox.getChildren().add(productorId);

        Button consulta = new Button("consulta");

        consulta.setOnAction(event -> {
            resultado.clear();
            List<Productor> productores = daoRelacional.getProductorDAO()
                    .productoresPorProduccionSimilar(Integer.parseInt(productorId.getText().trim()));
            resultado.appendText("Nombre \t\t Apellido \n");

            for (Productor productor: productores) {
                resultado.appendText(productor.getNombre() + "\t" + productor.getApellido() + "\n");
            }
        });

        hBox.getChildren().add(consulta);
        vBox.getChildren().add(hBox);
        vBox.getChildren().add(resultado);
    }

    @FXML
    public void pregunta8(){
        limpiar();

        List<Productor> productores = daoRelacional.getProductorDAO().productoresSinNombreNiProduccion();
        resultado.appendText("ID \t\t Nombre \t\t Apellido \t\t Region \n");

        for (Productor productor: productores) {
            resultado.appendText(
                    productor.getIdProductor() + "\t\t" +
                    productor.getNombre() + "\t\t" +
                    productor.getApellido() + "\t\t" +
                    productor.getRegion() + "\n");
        }

        vBox.getChildren().add(resultado);
    }
}
