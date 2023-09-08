package utfpr.classcontrol;

import utfpr.classcontrol.dao.PersonDao;
import utfpr.classcontrol.util.Factory;
import utfpr.classcontrol.util.Hud;
import javax.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager em = Factory.getEntityManager();
        PersonDao personDao = new PersonDao(em);
        var repeat = true;
        personDao.connect();

        do {
            var opt = Hud.mainMenu();

            switch (opt) {
                case 1:
                    // Create
                    var p = Hud.create(); // Recebe os dados do usuário e retorna um novo objeto
                    personDao.save(p);
                    System.out.println("Pessoa cadastrada com sucesso.");
                    break;
                case 2:
                    // Read
                    var persons = personDao.getAll(); // Busca os dados no db
                    Hud.listPersons(persons);
                    break;
                case 3:
                    // Update
                    var personToUpdate = personDao.getByCpf(Hud.getCpf("atualizar")); // Busca no banco a partir do CPF
                    personToUpdate = Hud.update(personToUpdate); // Retorna o objeto atualizado
                    personDao.update(personToUpdate); // Atualiza no em
                    personDao.save(personToUpdate); // Salva no banco
                    System.out.println("Pessoa atualizada com sucesso.");
                    break;
                case 4:
                    // Delete
                    var personToDelete = personDao.getByCpf(Hud.getCpf("excluir")); // Busca no banco a partir do CPF
                    personDao.remove(personToDelete);
                    System.out.println("Pessoa removida com sucesso.");
                    break;
                case 5:
                    repeat = false;
                    break;

            }
        } while (repeat);
    }
}