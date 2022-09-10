package model;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import repository.IClient;
import repository.ICommande;
import repository.IGestion;
import repository.IProduit;



public class Commande implements ICommande {
	private Client client;
	private List<Produit> produits;
	private int[] qteC;
	private Date date;
	private double total;
	private String code;
	public Commande(Client client, List<Produit> produits, int[] qteC, Date date, double total, String code) {
		super();
		this.client = client;
		this.produits = produits;
		this.qteC = qteC;
		this.date = date;
		this.total = total;
		this.code = code;
	}
	public Commande() {
		super();
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<Produit> getProduits() {
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	public int[] getQteC() {
		return qteC;
	}
	public void setQteC(int[] qteC) {
		this.qteC = qteC;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Override
	public void insertCommande(MongoCollection<Document> c, Document d) {
		// TODO Auto-generated method stub
			try {
				 c.insertOne(d);
				System.out.println("Success ! Inserted document ");
			}
			catch(MongoException me) {
				System.err.println("Unable to insert due to an error :"+me);
			}		
	}
	
	@Override
	public Document toDocument() {
		// TODO Auto-generated method stub
        Document docClient = IClient.getDocument(IGestion.ConnexioMongod("client"), client.getCin());
		
        Document document=new Document("client",docClient.getObjectId("_id").toString());
        List<Document> l = new ArrayList<Document>();
        Document docProduit ;
        int i=0;
        for(Produit p:produits) {
        	docProduit= IProduit.getDocument(IGestion.ConnexioMongod("produit"), p.getLibelle());
        	l.add(new Document("produit",docProduit.getObjectId("_id").toString()).append("qte", qteC[i++]));
        }
        document.append("produits", l);
        document.append("date",date);
        double totale=0;
        totale+=qteC[0]*produits.get(0).getPrixU();
        document.append("total", totale);
        document.append("code", code);
		return document;
	}

	@Override
	public void deletCommande (MongoCollection<Document> c,String codeC) {
		// TODO Auto-generated method stub
		try {
			
            DeleteResult result = c.deleteOne(eq("code",codeC));
            System.out.println("Deleted document count: " + result.getDeletedCount());
        } catch (MongoException me) {
            System.err.println("Unable to delete due to an error: " + me);
        }	
		
	}

	@Override
	public void updateCommande(MongoCollection<Document> c,String codeC,Commande commande)
	{
		// TODO Auto-generated method stub
			try {


		        Document docClient = IClient.getDocument(IGestion.ConnexioMongod("client"), client.getCin());
		        

				 Document docProduit ;
			     List<Document> l = new ArrayList<Document>();
			        int i=0;
			        for(Produit p:commande.getProduits()) {
			        	docProduit= IProduit.getDocument(IGestion.ConnexioMongod("produit"), p.getLibelle());
			        	l.add(new Document("produit",docProduit.getObjectId("_id").toString()).append("qte",commande.getQteC()[i++]));
			        	//totale+=p.getPrixU()*commande.getQteC()[i++];
			        }
				UpdateResult result = c.updateOne(eq("code",codeC),Updates.combine(Updates.set("client",docClient.getObjectId("_id").toString()),Updates.set("produits",l),Updates.set("date",commande.getDate()),Updates.set("total", commande.getTotal())));
				System.out.println("Success ! Modified document id : "+result.getUpsertedId());
			}
			catch(MongoException me) {
				System.err.println("Unable to update due to an error :"+me);
			}
		}

}
