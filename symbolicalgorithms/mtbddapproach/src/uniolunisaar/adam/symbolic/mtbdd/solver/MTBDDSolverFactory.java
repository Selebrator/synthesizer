package uniolunisaar.adam.symbolic.mtbdd.solver;

import java.io.IOException;
import uniol.apt.io.parser.ParseException;
import uniolunisaar.adam.ds.exceptions.CouldNotFindSuitableWinningConditionException;
import uniolunisaar.adam.ds.exceptions.NetNotSafeException;
import uniolunisaar.adam.ds.exceptions.NoSuitableDistributionFoundException;
import uniolunisaar.adam.logic.exceptions.ParameterMissingException;
import uniolunisaar.adam.ds.exceptions.NotSupportedGameException;
import uniolunisaar.adam.ds.exceptions.SolvingException;
import uniolunisaar.adam.ds.petrigame.PetriGame;
import uniolunisaar.adam.ds.objectives.Buchi;
import uniolunisaar.adam.ds.objectives.Reachability;
import uniolunisaar.adam.ds.objectives.Safety;
import uniolunisaar.adam.logic.solver.SolverFactory;
import uniolunisaar.adam.ds.objectives.Condition;

/**
 *
 * @author Manuel Gieseking
 */
public class MTBDDSolverFactory extends SolverFactory<MTBDDSolverOptions, MTBDDSolver<? extends Condition>> {

    private static MTBDDSolverFactory instance = null;

    public static MTBDDSolverFactory getInstance() {
        if (instance == null) {
            instance = new MTBDDSolverFactory();
        }
        return instance;
    }

    private MTBDDSolverFactory() {

    }

    public MTBDDSolver<? extends Condition> getSolver(PetriGame game, boolean skipTests) throws SolvingException, CouldNotFindSuitableWinningConditionException {
        return super.getSolver(game, skipTests, new MTBDDSolverOptions());
    }

    public MTBDDSolver<? extends Condition> getSolver(String file, boolean skipTests) throws SolvingException, IOException, ParseException, CouldNotFindSuitableWinningConditionException {
        return super.getSolver(file, skipTests, new MTBDDSolverOptions());
    }

    public MTBDDSolver<? extends Condition> getSolver(String file) throws ParseException, IOException, NotSupportedGameException, NetNotSafeException, NoSuitableDistributionFoundException, CouldNotFindSuitableWinningConditionException, ParameterMissingException, SolvingException {
        return super.getSolver(file, new MTBDDSolverOptions());
    }

    @Override
    protected MTBDDSolver<? extends Condition> getESafetySolver(PetriGame game, Safety winCon, boolean skipTests, MTBDDSolverOptions options) throws SolvingException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected MTBDDSolver<? extends Condition> getASafetySolver(PetriGame game, Safety winCon, boolean skipTests, MTBDDSolverOptions options) throws NotSupportedGameException, NetNotSafeException, NoSuitableDistributionFoundException, ParameterMissingException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected MTBDDSolver<? extends Condition> getEReachabilitySolver(PetriGame game, Reachability winCon, boolean skipTests, MTBDDSolverOptions options) throws NotSupportedGameException, NetNotSafeException, NoSuitableDistributionFoundException, ParameterMissingException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected MTBDDSolver<? extends Condition> getAReachabilitySolver(PetriGame game, Reachability winCon, boolean skipTests, MTBDDSolverOptions options) throws NotSupportedGameException, NetNotSafeException, NoSuitableDistributionFoundException, ParameterMissingException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected MTBDDSolver<? extends Condition> getEBuchiSolver(PetriGame game, Buchi winCon, boolean skipTests, MTBDDSolverOptions options) throws NotSupportedGameException, NetNotSafeException, NoSuitableDistributionFoundException, ParameterMissingException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected MTBDDSolver<? extends Condition> getABuchiSolver(PetriGame game, Buchi winCon, boolean skipTests, MTBDDSolverOptions options) throws NotSupportedGameException, NetNotSafeException, NoSuitableDistributionFoundException, ParameterMissingException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
