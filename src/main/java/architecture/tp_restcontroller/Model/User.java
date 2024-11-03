package architecture.tp_restcontroller.Model;

public class User {
    int id;
    String nom;
    String mail;
    public User(int id, String nom, String mail) {
        this.id = id;
        this.nom = nom;
        this.mail = mail;
    }
    public int getId() { return id;
    }
    public void setId(int id) {this.id = id;
    }
    public String getNom() {return nom;
    }
    public void setNom(String nom) {this.nom = nom;
    }
    public String getMail() {return mail;
    }
    public void setMail(String mail) { this.mail = mail;
    }
}
