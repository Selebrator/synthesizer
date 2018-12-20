package uniolunisaar.adam.symbolic.mtbdd.solver;

import uniolunisaar.adam.ds.exceptions.NetNotSafeException;
import uniolunisaar.adam.ds.exceptions.NoSuitableDistributionFoundException;
import uniolunisaar.adam.ds.exceptions.SolverDontFitPetriGameException;
import uniolunisaar.adam.ds.exceptions.NotSupportedGameException;
import uniolunisaar.adam.ds.petrigame.PetriGame;
import uniolunisaar.adam.ds.solver.Solver;
import uniolunisaar.adam.ds.objectives.Condition;
import uniolunisaar.adam.symbolic.mtbdd.petrigame.MTBDDSolvingObject;

/**
 *
 * @author Manuel Gieseking
 * @param <W>
 */
public abstract class MTBDDSolver<W extends Condition> extends Solver<MTBDDSolvingObject<W>, MTBDDSolverOptions> {

    /**
     * Creates a new solver for the given game.
     *
     * @param game - the games which should be solved.
     * @throws SolverDontFitPetriGameException - thrown if the created solver
     * don't fit the given winning objective specified in the given game.
     */
    MTBDDSolver(PetriGame game, boolean skipTests, W winCon, MTBDDSolverOptions opts) throws NotSupportedGameException, NetNotSafeException, NoSuitableDistributionFoundException {
        super(new MTBDDSolvingObject<>(game, winCon), opts);
    }
    
}
