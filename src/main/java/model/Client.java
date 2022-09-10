package model;

import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.result.DeleteResult;

import repository.IClient;

public class Client implements IClient{
	private String nom;
	private String prenom;
	private String cin;
	private String telephone;
	private String address;
	public Client(String nom, String prenom, String cin, String telephone, String address) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.telephone = telephone;
		this.address = address;
	}
	public Client() {
		super();
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public void insertClient(MongoCollection<Document> c, Document client) {
		// TODO Auto-generated method stub
		if (!clientDispo(c,client.getString("cin"))) {
			try {
				 c.insertOne(client);
				System.out.println("Success ! Inserted document ");
			}
			catch(MongoException me) {
				System.err.println("Unable to insert due to an error :"+me);
			}
		}
		else 
			System.out.println("Client already disponible!");
		
	}
	@Override
	public Document toDocument() {
		// TODO Auto-generated method stub
		return new Document("nom",nom).append("prenom", prenom).append("adress", address).append("cin", cin).append("N Telephone", telephone);

	}
	@Override
	public void deleteClient(MongoCollection<Document> c, String cin) {
		// TODO Auto-generated method stub
		try {
            DeleteResult result = c.deleteOne(eq("cin",cin));
            System.out.println("Deleted document count: " + result.getDeletedCount());
        } catch (MongoException me) {
            System.err.println("Unable to delete due to an error: " + me);
        }	
	}

	@Override
	public boolean clientDispo(MongoCollection<Document> c, String cin) {
		// TODO Auto-generated method stub
		MongoCursor<Document> cursor = c.find(eq("cin",cin)).iterator();
		if(cursor.hasNext())
			return true;
		return false;
	}
	
}
