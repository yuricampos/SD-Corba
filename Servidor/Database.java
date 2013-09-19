import java.io.IOException;
import java.util.Properties;
import jdbm.RecordManager;
import jdbm.RecordManagerFactory;
import jdbm.htree.HTree;

public class Database {

    RecordManager recman;
    HTree hashtable;

    public Database() throws IOException {
        Properties props = new Properties();
        recman = RecordManagerFactory.createRecordManager("contatos", props);
        long recid = recman.getNamedObject("contatos");
        if (recid != 0) {
            //  System.out.println("Carregando banco de dados...");
            hashtable = HTree.load(recman, recid);
            recman.commit();
        } else {
            //    System.out.println("Criando banco de dados...");
            hashtable = HTree.createInstance(recman);
            recman.setNamedObject("contatos", hashtable.getRecid());
            recman.commit();
        }

    }

    public int cadastrar(String nome, String telefone) throws IOException {
        if (hashtable.get(nome) != null) {
            return 0;
        } else {
            hashtable.put(nome, telefone);
            recman.commit();
            return 1;
        }
    }

    public int atualizar(String nome, String telefone) throws IOException {
        if (hashtable.get(nome) == null) {
            return 0;
        } else {
            hashtable.put(nome, telefone);
            recman.commit();
            return 1;
        }
    }

    public int apagar(String nome) throws IOException {
        if (hashtable.get(nome) == null) {
            return 0;
        } else {
            hashtable.remove(nome);
            recman.commit();
            return 1;
        }
    }

    public String consultar(String nome) throws IOException {
        if (hashtable.get(nome) == null) {
            return "nao";
        } else {
            String telefone = (String) hashtable.get(nome);
            return telefone;

        }
    }

}
