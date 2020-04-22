package fr.ourson.utils

/**
 * Classe d'exemple représentant une classe utilitaire pour un pipeline.
 */
class Utilities implements Serializable{
    Script steps

    Utilities(Script steps) {
        this.steps = steps
    }

    /**
     * Méthode permettant d'exécuter une commande Maven.
     * @param args Maven arguments.
     */
    void mvn(String args) {
        steps.sh "mvn ${args}"
    }
}
