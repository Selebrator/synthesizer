package uniolunisaar.adam.symbolic.bddapproach.solver;

import net.sf.javabdd.BDD;
import uniol.apt.adt.pn.Transition;

/**
 *
 * @author Manuel Gieseking
 */
public interface BDDType2Solver {

    public boolean isType2(BDD states);

    public BDD getSystem2SuccTransitions(BDD state);

    public BDD getGoodType2Succs(BDD trans);

    public BDD getFirstBDDVariables();

    public Transition getTransition(BDD source, BDD target);
}