package Dao;

import entity.Client;

import java.util.List;

public interface IClientDao {

    void addClient(List<Client> clients,Client client);
    void deleteClient(List<Client> clients,Client client);
    void editName(Client client, String newName);
    void editAddress(Client client, String newAddress);
    void editEmail(Client client, String newEmail);
    void editIndex(Client client, int newIndex);
    void editPhone(Client client, String newPhone);
    Client getClient(List<Client> clients,String name);
    List<Client> getAll();
}
