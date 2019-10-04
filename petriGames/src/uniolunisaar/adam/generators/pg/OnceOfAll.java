package uniolunisaar.adam.generators.pg;

import uniol.apt.adt.pn.Place;
import uniol.apt.adt.pn.Transition;
import uniolunisaar.adam.ds.petrigame.PetriGame;
import uniolunisaar.adam.ds.petrinet.objectives.Condition;
import uniolunisaar.adam.util.PGTools;
import uniolunisaar.adam.util.PNWTTools;

/**
 *
 * @author Manuel Gieseking
 */
public class OnceOfAll {

    public static PetriGame generate(int n, boolean withEnvironment) {
        if (n < 1) {
            //todo: Exception
            System.out.println("Error");
        }
        PetriGame pn = PGTools.createPetriGame("OnceOfAll_" + n);
        PNWTTools.setConditionAnnotation(pn, Condition.Objective.A_SAFETY);

        int start = 0;
        if (withEnvironment) {
            Place p = pn.createEnvPlace();
            p.setInitialToken(1);
            Transition t = pn.createTransition();
            pn.createFlow(p, t);
            pn.createFlow(t, p);
            start = 1;
        }
        for (int i = start; i < n; i++) {
            Place p = pn.createPlace();
            Transition t = pn.createTransition();
            pn.createFlow(p, t);
            pn.createFlow(t, p);
        }
        return pn;
    }
}
