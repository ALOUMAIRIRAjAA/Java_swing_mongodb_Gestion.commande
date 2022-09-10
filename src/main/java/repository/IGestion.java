package repository;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;



public interface IGestion {
	public static  MongoCollection<Document> ConnexioMongod (String collection) {
		
		MongoClient mongoClient =  MongoClients.create();
		MongoDatabase database = mongoClient.getDatabase("gestionCommandes");
        MongoCollection<Document> Collection = database.getCollection(collection);
		return Collection;
	}
	
	public static void afficherCommandes (JTable table) {
		List<Document> commandes =ICommande.getAllCommande(ConnexioMongod("commande"));
        // for (Document c1:commandes) {
        // 	System.out.println(c1);
         //

        String[] coulunmnames = {"Code","Cin","Nom Client","Nom Produit","Quantite","Total"};
        DefaultTableModel model = new DefaultTableModel(coulunmnames,0);
    	model.addRow(new Object[] {coulunmnames[0],coulunmnames[1],coulunmnames[2],coulunmnames[3],coulunmnames[4],coulunmnames[5]});

        for(Document ppp:commandes) {
        	
        	String clientN= (IClient.getDocumentById(ConnexioMongod("client"), ppp.getString("client"))).getString("nom");
        	String cinN=(IClient.getDocumentById(ConnexioMongod("client"), ppp.getString("client"))).getString("cin");
           	@SuppressWarnings("unchecked")
			List<Document> docccc =(List<Document>) ppp.get("produits");
        	String produitN=(IProduit.getDocumentById(ConnexioMongod("produit"), (docccc.get(0).getString("produit")))).getString("libelle");
        	int qtecc=docccc.get(0).getInteger("qte");
        	double total=ppp.getDouble("total");
        	String codeC=ppp.getString("code");
        	model.addRow(new Object[] {codeC,cinN,clientN,produitN,qtecc,total+" Dh"});
        }
        table.setModel(model);
	}
	
	public static void afficherProduits (JTable table) {

	

    List<Document> product =IProduit.getAllProduit(ConnexioMongod("produit"));
    String[] coulunmnames = {"Libelle","Quantite","Prix Unitaire"};
    DefaultTableModel model = new DefaultTableModel(coulunmnames,0);
	model.addRow(new Object[] {coulunmnames[0],coulunmnames[1],coulunmnames[2]});

    for(Document ppp:product) {
    	String liblle= ppp.getString("libelle");
    	int qte=ppp.getInteger("qte");
    	double prixU=ppp.getDouble("prix");
    	model.addRow(new Object[] {liblle,qte,prixU});
    }
    table.setModel(model);
	}
	
	public static void afficherClients (JTable table) {

	List<Document> product =IClient.getAllClient(ConnexioMongod("client"));
    String[] coulunmnames = {"Cin","Nom","Prenom","Telephone","Adresse"};
    DefaultTableModel model = new DefaultTableModel(coulunmnames,0);
	model.addRow(new Object[] {coulunmnames[0],coulunmnames[1],coulunmnames[2],coulunmnames[3],coulunmnames[4]});

    for(Document ppp:product) {
    	String cin=ppp.getString("cin");
    	String nom= ppp.getString("nom");
    	String prenom=ppp.getString("prenom");
    	String adresse=ppp.getString("adress");
    	String telephone=ppp.getString("N Telephone");
    	model.addRow(new Object[] {cin,nom,prenom,telephone,adresse});
    }
    table.setModel(model);
	}
}
