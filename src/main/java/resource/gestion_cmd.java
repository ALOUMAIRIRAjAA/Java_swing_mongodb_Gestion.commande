package resource;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.bson.Document;

import model.Client;
import model.Commande;
import model.Produit;
import repository.ICommande;
import repository.IGestion;
import repository.IProduit;

import javax.swing.JList;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.border.BevelBorder;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;

public class gestion_cmd {

	private JFrame frame;
	private JTextField cin;
	private JTextField nom;
	private JTextField prenom;
	private JTextField adress;
	private JTextField produit;
	private JTextField qte;
	private JTextField code;
	private JTextField libelle;
	private JTextField qteStock;
	private JTextField prixU;
	private JButton btnNewButton_6;
	private JTable table;
	private JButton btnNewButton_8;
	private JButton btnNewButton_9;
	private JButton btnNewButton_10;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestion_cmd window = new gestion_cmd();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gestion_cmd() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setType(Type.POPUP);
		frame.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		frame.getContentPane().setBackground(new Color(160, 82, 45));
		frame.setBounds(100, 100, 1057, 902);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("         Gestion de Commande");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(96, 0, 682, 31);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel.setBackground(Color.CYAN);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CIN");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1.setBounds(65, 51, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		cin = new JTextField();
		cin.setBounds(137, 48, 86, 20);
		frame.getContentPane().add(cin);
		cin.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nom");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_2.setBounds(65, 76, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		nom = new JTextField();
		nom.setBounds(137, 73, 86, 20);
		frame.getContentPane().add(nom);
		nom.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Prenom");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_3.setBounds(65, 101, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		prenom = new JTextField();
		prenom.setBounds(137, 98, 86, 20);
		frame.getContentPane().add(prenom);
		prenom.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Adress");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_4.setBounds(65, 126, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		adress = new JTextField();
		adress.setBounds(137, 123, 86, 20);
		frame.getContentPane().add(adress);
		adress.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("N_telephone");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_5.setBounds(65, 151, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JTextField telephone = new JTextField();
		telephone.setBounds(137, 148, 86, 20);
		frame.getContentPane().add(telephone);
		telephone.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Produits");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_6.setBounds(65, 176, 46, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		produit = new JTextField();
		produit.setBounds(137, 173, 86, 20);
		frame.getContentPane().add(produit);
		produit.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Qauntite");
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_7.setBounds(65, 201, 46, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		qte = new JTextField();
		qte.setBounds(137, 198, 86, 20);
		frame.getContentPane().add(qte);
		qte.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Code");
		lblNewLabel_8.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_8.setBounds(65, 226, 46, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		code = new JTextField();
		code.setBounds(137, 223, 86, 20);
		frame.getContentPane().add(code);
		code.setColumns(10);
		
		JButton btnNewButton = new JButton("Commander");
		btnNewButton.setBackground(new Color(218, 165, 32));
		btnNewButton.setFont(new Font("Arial", Font.ITALIC, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Produit> products =new ArrayList<Produit>();
				Client client=new Client(nom.getText().toString(),prenom.getText().toString(),cin.getText().toString(),telephone.getText().toString(),adress.getText().toString());
				Document docProduit=IProduit.getDocument(IGestion.ConnexioMongod("produit"), produit.getText().toString());
				Produit produit=new Produit(docProduit.getString("libelle"),docProduit.getInteger("qte"),docProduit.getDouble("prix"));
				products.add(produit);
				
				int [] qteC = {Integer.parseInt(qte.getText().toString())};
				double totale=0;
				totale+=qteC[0]*produit.getPrixU();
				Commande commande =new Commande(client,products,qteC,new Date(),totale,ICommande.genererCodeC(IGestion.ConnexioMongod("commande")));
				client.insertClient(IGestion.ConnexioMongod("client"), client.toDocument());
				produit.updateProduit(IGestion.ConnexioMongod("produit"),produit,qteC[0]);
				commande.insertCommande(IGestion.ConnexioMongod("commande"), commande.toDocument());
				
				//Afficher Commandes
				IGestion.afficherCommandes(table_3);
				IGestion.afficherProduits(table_2);
			}
		});
		btnNewButton.setBounds(30, 264, 100, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modifier");
		btnNewButton_1.setBackground(new Color(218, 165, 32));
		btnNewButton_1.setFont(new Font("Arial", Font.ITALIC, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Update Commande
				String codeC= code.getText().toString();
				
				
	            List<Produit> products =new ArrayList<Produit>();
				Client client=new Client(nom.getText().toString(),prenom.getText().toString(),telephone.getText().toString(),cin.getText().toString(),telephone.getText().toString());
				Document docProduit=IProduit.getDocument(IGestion.ConnexioMongod("produit"), produit.getText().toString());
				Produit produit=new Produit(docProduit.getString("libelle"),docProduit.getInteger("qte"),docProduit.getDouble("prix"));
				Document oldCommande=ICommande.getDocument(IGestion.ConnexioMongod("commande"), codeC);
				@SuppressWarnings("unchecked")
				List<Document> docccc =(List<Document>) oldCommande.get("produits");

				products.add(produit);
				
				int [] qteC = {Integer.parseInt(qte.getText().toString())};
				double totale=0;
				totale+=qteC[0]*produit.getPrixU();
				Commande commande =new Commande(client,products,qteC,new Date(),totale,"C0003");
				client.insertClient(IGestion.ConnexioMongod("client"), client.toDocument());
				produit.updateProduit(IGestion.ConnexioMongod("produit"), produit, commande.getQteC()[0]-docccc.get(0).getInteger("qte"));

				commande.updateCommande(IGestion.ConnexioMongod("commande"), codeC, commande);
				
				//Afficher Commandes
				IGestion.afficherCommandes(table_3);
				IGestion.afficherProduits(table_2);
			}
		});
		btnNewButton_1.setBounds(147, 264, 97, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Supprimer");
		btnNewButton_2.setBackground(new Color(218, 165, 32));
		btnNewButton_2.setFont(new Font("Arial", Font.ITALIC, 11));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codeC;
				codeC = code.getText().toString();
	
				Commande  commande =new Commande();
				commande.deletCommande(IGestion.ConnexioMongod("commande"),codeC);
				
				
				//Afficher Commandes
				IGestion.afficherCommandes(table_3);
			}
		});
		btnNewButton_2.setBounds(254, 264, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 205));
		panel.setBounds(10, 35, 424, 281);
		frame.getContentPane().add(panel);
		table = new JTable();
		JButton btnNewButton_3 = new JButton("Listes des Clients");
		btnNewButton_3.setFont(new Font("Arial", Font.ITALIC, 13));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IGestion.afficherClients(table_1);
			}
		});
		btnNewButton_3.setBackground(new Color(218, 165, 32));
		btnNewButton_3.setBounds(86, 327, 279, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Listes des Produits");
		btnNewButton_4.setBackground(new Color(218, 165, 32));
		btnNewButton_4.setFont(new Font("Arial", Font.ITALIC, 13));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IGestion.afficherProduits(table_2);
			}
		});
		btnNewButton_4.setBounds(539, 327, 279, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		JLabel lblNewLabel_9 = new JLabel("Libelle");
		lblNewLabel_9.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_9.setBounds(51, 530, 60, 14);
		frame.getContentPane().add(lblNewLabel_9);
		
		libelle = new JTextField();
		libelle.setBounds(161, 527, 86, 20);
		frame.getContentPane().add(libelle);
		libelle.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Quantite");
		lblNewLabel_10.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_10.setBounds(51, 574, 86, 14);
		frame.getContentPane().add(lblNewLabel_10);
		
		qteStock = new JTextField();
		qteStock.setBounds(161, 571, 86, 20);
		frame.getContentPane().add(qteStock);
		qteStock.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Prix");
		lblNewLabel_11.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_11.setBounds(51, 618, 46, 14);
		frame.getContentPane().add(lblNewLabel_11);
		
		prixU = new JTextField();
		prixU.setBounds(161, 615, 86, 20);
		frame.getContentPane().add(prixU);
		prixU.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("listes des commandes");
		btnNewButton_5.setBackground(new Color(218, 165, 32));
		btnNewButton_5.setFont(new Font("Arial", Font.ITALIC, 11));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				IGestion.afficherCommandes(table_3);

			}
		});
		btnNewButton_5.setBounds(886, 72, 145, 56);
		frame.getContentPane().add(btnNewButton_5);
		
		btnNewButton_6 = new JButton("Imprimer");
		btnNewButton_6.setBackground(new Color(218, 165, 32));
		btnNewButton_6.setFont(new Font("Arial", Font.ITALIC, 12));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Imprimerr
				MessageFormat entete = new MessageFormat("Commandes");
				MessageFormat pied =new MessageFormat("Page )");
				try {
					table_3.print(JTable.PrintMode.FIT_WIDTH,entete,pied);
				}catch(Exception ee) {
					JOptionPane.showConfirmDialog(null, "erruer : \n "+ee,"Impresion",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_6.setBounds(886, 172, 145, 46);
		frame.getContentPane().add(btnNewButton_6);
		
		btnNewButton_8 = new JButton("Ajouter");
		btnNewButton_8.setBackground(new Color(218, 165, 32));
		btnNewButton_8.setFont(new Font("Arial", Font.ITALIC, 12));
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Add produit
				Produit produit=new Produit(libelle.getText().toString(),Integer.parseInt(qteStock.getText().toString()),Double.parseDouble(prixU.getText().toString()));
	            
	            produit.insertProduit(IGestion.ConnexioMongod("produit"), produit.toDocument());
	            
	            IGestion.afficherProduits(table_2);

	            
			}
		});
		btnNewButton_8.setBounds(22, 665, 89, 23);
		frame.getContentPane().add(btnNewButton_8);
		
		btnNewButton_9 = new JButton("Modifier");
		btnNewButton_9.setBackground(new Color(218, 165, 32));
		btnNewButton_9.setFont(new Font("Arial", Font.ITALIC, 12));
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String libel = libelle.getText().toString();
				Produit p=new Produit(libel,0,0);
				p.updatePrixProduit(IGestion.ConnexioMongod("produit"),p,Double.parseDouble(prixU.getText().toString()));
				IGestion.afficherProduits(table_2);
			}
		});
		btnNewButton_9.setBounds(182, 665, 89, 23);
		frame.getContentPane().add(btnNewButton_9);
		
		btnNewButton_10 = new JButton("Supprimer");
		btnNewButton_10.setBackground(new Color(218, 165, 32));
		btnNewButton_10.setFont(new Font("Arial", Font.ITALIC, 12));
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//delete produit
				Produit p=new Produit();
				p.deleteproduit(IGestion.ConnexioMongod("produit"), libelle.getText().toString());
				IGestion.afficherProduits(table_2);
			}
		});
		btnNewButton_10.setBounds(332, 665, 100, 23);
		frame.getContentPane().add(btnNewButton_10);
		
		table_1 = new JTable();
		table_1.setBackground(new Color(255, 250, 205));
		table_1.setBounds(10, 377, 423, 93);
		frame.getContentPane().add(table_1);
		
		table_2 = new JTable();
		table_2.setBackground(new Color(255, 250, 205));
		table_2.setBounds(451, 377, 455, 93);
		frame.getContentPane().add(table_2);
		
		table_3 = new JTable();
		table_3.setBackground(new Color(255, 250, 205));
		table_3.setBounds(451, 35, 423, 281);
		frame.getContentPane().add(table_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 250, 205));
		panel_1.setBounds(10, 509, 431, 203);
		frame.getContentPane().add(panel_1);
	}
}
