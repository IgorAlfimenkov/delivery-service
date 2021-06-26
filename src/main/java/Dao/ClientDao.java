package Dao;

import entity.Client;

import java.util.List;

public class ClientDao implements IClientDao {

    Database db = Database.getInstance();

    @Override
    public void addClient(List<Client> clients,Client client) {
        db.addClient(clients,client);
    }

    @Override
    public void deleteClient(List<Client> clients,Client client) {
        db.deleteClient(clients,client);
    }

    @Override
    public void editName(Client client, String newName) {

        client.setName(newName);
    }

    @Override
    public void editAddress(Client client, String newAddress) {

        client.setAddress(newAddress);
    }

    @Override
    public void editEmail(Client client, String newEmail) {

        client.setEmail(newEmail);
    }

    @Override
    public void editIndex(Client client, int newIndex) {

        client.setIndex(newIndex);
    }

    @Override
    public void editPhone(Client client, String newPhone) {

        client.setPhone(newPhone);
    }

    @Override
    public Client getClient(List<Client> clients,String name) {
        return db.getClient(clients,name);
    }

    @Override
    public List<Client> getAll() {
        return db.getAllClients();
    }
}
