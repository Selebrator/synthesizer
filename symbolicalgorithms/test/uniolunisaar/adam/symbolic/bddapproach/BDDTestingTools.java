package uniolunisaar.adam.symbolic.bddapproach;

import java.io.IOException;
import org.testng.Assert;
import uniol.apt.adt.pn.PetriNet;
import uniol.apt.analysis.coverability.CoverabilityGraph;
import uniol.apt.analysis.exception.UnboundedException;
import uniol.apt.util.Pair;
import uniolunisaar.adam.ds.exceptions.NetNotSafeException;
import uniolunisaar.adam.ds.exceptions.NoStrategyExistentException;
import uniolunisaar.adam.ds.exceptions.NoSuitableDistributionFoundException;
import uniolunisaar.adam.symbolic.bddapproach.graph.BDDGraph;
import uniolunisaar.adam.ds.winningconditions.WinningCondition;
import uniolunisaar.adam.logic.util.AdamTools;
import uniolunisaar.adam.symbolic.bddapproach.solver.BDDSolver;
import uniolunisaar.adam.symbolic.bddapproach.util.BDDTools;

/**
 *
 * @author Manuel Gieseking
 */
public class BDDTestingTools {

    public static void testExample(BDDSolver<? extends WinningCondition> solv, String file, boolean hasStrategy) throws NetNotSafeException, NoStrategyExistentException, IOException, InterruptedException, NoSuitableDistributionFoundException, UnboundedException {
        CoverabilityGraph cover = CoverabilityGraph.getReachabilityGraph(solv.getNet());
        AdamTools.savePG2PDF(file, solv.getNet(), false);
        Assert.assertTrue(AdamTools.isSolvablePetriGame(solv.getNet(), cover) == null, "Is solvable:");
//        BDDTools.saveGraph2PDF(file + "_graph", solv.getGraphGame(), solv.getGame());
        AdamTools.savePG2PDF(file + "_debug", solv.getNet(), true, solv.getGame().getMaxTokenCountInt());
        if (hasStrategy) {
            Assert.assertTrue(solv.existsWinningStrategy(), "Net: " + solv.getNet().getName() + " has winning strategy: ");
            printWinningStrategies(solv, file);
        } else {
            Assert.assertFalse(solv.existsWinningStrategy(), "Net: " + solv.getNet().getName() + " has winning strategy: ");
        }
    }

    static void testExample(BDDSolver<? extends WinningCondition> solv, String file) throws NetNotSafeException, NoStrategyExistentException, IOException, InterruptedException, NoSuitableDistributionFoundException, UnboundedException {
        testExample(solv, file, true);
    }

    private static void printWinningStrategies(BDDSolver<? extends WinningCondition> solv, String path) throws NoStrategyExistentException, IOException, InterruptedException {
        Pair<BDDGraph, PetriNet> strats = solv.getStrategies();
        //        System.out.println("Save graph to pdf.");
        BDDTools.saveGraph2PDF(path + "_gg", strats.getFirst(), solv);
//        System.out.println("Save petri game pdf.");
        AdamTools.savePG2PDF(path + "_pg", strats.getSecond(), true);

        //   Tools.savePN2DotAndPDF(path + "_debug", pg.getNet(), true, pg);        
        CoverabilityGraph cover = CoverabilityGraph.getReachabilityGraph(strats.getSecond());
        boolean det = AdamTools.isDeterministic(strats.getSecond(), cover);
        Assert.assertTrue(det, strats.getSecond().getName() + " is deterministic");
        boolean res = AdamTools.restrictsEnvTransition(solv.getNet(), strats.getSecond());
        Assert.assertFalse(res, strats.getSecond().getName() + " restricts Environment Transitions");
        if (!(solv.getWinningCondition().getObjective().equals(WinningCondition.Objective.A_REACHABILITY) || solv.getWinningCondition().getObjective().equals(WinningCondition.Objective.E_REACHABILITY))) {
            if (!solv.getWinningCondition().getObjective().equals(WinningCondition.Objective.E_SAFETY)) { // todo: we have to develop a notion for deadlock-avoiding but ok when goal reached
                boolean dead = AdamTools.isDeadlockAvoiding(solv.getNet(), strats.getSecond(), cover);
                Assert.assertTrue(dead, strats.getSecond().getName() + " is Deadlock Avoiding");
            }
        }
    }

    private static void printWinningStratGraph(BDDSolver<? extends WinningCondition> solv, String path) throws NoStrategyExistentException, IOException, InterruptedException {
        BDDGraph strat = solv.getGraphStrategy();

        BDDTools.saveGraph2DotAndPDF(path + "_gg", strat, solv);
    }

    private static void printWinningStratPG(BDDSolver<? extends WinningCondition> solv, String path) throws NoStrategyExistentException, IOException, InterruptedException {
        PetriNet strategy = solv.getStrategy();
        AdamTools.savePG2DotAndPDF(path + "_pg", strategy, true);
    }

}
