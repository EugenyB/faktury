package com.bogdan.faktury;

import com.bogdan.faktury.db.Artykul;
import com.bogdan.faktury.db.Client;
import com.bogdan.faktury.db.dao.ArtykulDAO;
import com.bogdan.faktury.db.dao.ClientDAO;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;

import java.util.List;

public class MainController {

    @FXML
    private ListView<Artykul> artykulsListView;
    @FXML
    private ListView<Client> clientListView;

    public void initialize() {
        fillClients();
        fillArtykuls();
    }

    private void fillArtykuls() {
        artykulsListView.setItems(FXCollections.observableList(new ArtykulDAO().findAll()));
    }

    private void fillClients() {
        List<Client> clients = new ClientDAO().findAll();
        clientListView.setItems(FXCollections.observableList(clients));
    }

    public void showFaktura() {
        Client client = clientListView.getSelectionModel().getSelectedItem();
        if (client!=null) {
            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setTitle("Factura - " + client.getName());
            alert.setHeaderText(null);
            String contentText = createFakturaText(client);
            alert.setContentText(contentText);
            alert.getButtonTypes().add(ButtonType.CLOSE);
            alert.show();
        }
    }

    private String createFakturaText(Client client) {
        return "line 1\nline 2\nline 3";
    }
}