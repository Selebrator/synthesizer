package uniolunisaar.adam.symbolic.bddapproach;

import java.io.IOException;
import org.testng.Assert;
import uniol.apt.adt.pn.PetriNet;
import uniol.apt.analysis.exception.UnboundedException;
import uniol.apt.util.Pair;
import uniolunisaar.adam.ds.exceptions.NetNotSafeException;
import uniolunisaar.adam.ds.exceptions.NoStrategyExistentException;
import uniolunisaar.adam.ds.exceptions.NoSuitableDistributionFoundException;
import uniolunisaar.adam.symbolic.bddapproach.graph.BDDGraph;
import uniolunisaar.adam.ds.winningconditions.WinningCondition;
import uniolunisaar.adam.symbolic.bddapproach.solver.BDDSolver;
import uniolunisaar.adam.symbolic.bddapproach.util.BDDTools;
import uniolunisaar.adam.tools.Tools;

/**
 *
 * @author Manuel Gieseking
 */
public class BDDTestingTools {

    public static void testExample(BDDSolver<? extends WinningCondition> solv, String file, boolean hasStrategy) throws NetNotSafeException, NoStrategyExistentException, IOException, InterruptedException, NoSuitableDistributionFoundException, UnboundedException {
        Tools.savePN2PDF(file, solv.getNet(), false);
//        BDDTools.saveGraph2PDF(file + "_graph", solv.getGraphGame(), solv.getGame());
        Tools.savePN2PDF(file + "_debug", solv.getNet(), true, solv.getGame().getMaxTokenCountInt());
        if (hasStrategy) {
            Assert.assertTrue(solv.existsWinningStrategy());
            printWinningStrategies(solv, file);
        } else {
            Assert.assertFalse(solv.existsWinningStrategy());
        }
    }

    static void testExample(BDDSolver<? extends WinningCondition> solv, String file) throws NetNotSafeException, NoStrategyExistentException, IOException, InterruptedException, NoSuitableDistributionFoundException, UnboundedException {
        testExample(solv, file, true);
    }

    private static void printWinningStrategies(BDDSolver<? extends WinningCondition> solv, String path) throws NoStrategyExistentException, IOException, InterruptedException {
        Pair<BDDGraph, PetriNet> strats = solv.getStrategies();
       //   Tools.savePN2DotAndPDF(path + "_debug", pg.getNet(), true, pg);
        System.out.println("Save graph to pdf.");
        BDDTools.saveGraph2PDF(path + "_gg", strats.getFirst(), solv);
        System.out.println("Save petri game pdf.");
        Tools.savePN2PDF(path + "_pg", strats.getSecond(), true);
    }

    private static void printWinningStratGraph(BDDSolver<? extends WinningCondition> solv, String path) throws NoStrategyExistentException, IOException, InterruptedException {
        BDDGraph strat = solv.getGraphStrategy();

        BDDTools.saveGraph2DotAndPDF(path + "_gg", strat, solv);
    }

    private static void printWinningStratPG(BDDSolver<? extends WinningCondition> solv, String path) throws NoStrategyExistentException, IOException, InterruptedException {
        PetriNet strategy = solv.getStrategy();
        Tools.savePN2DotAndPDF(path + "_pg", strategy, true);
    }

}