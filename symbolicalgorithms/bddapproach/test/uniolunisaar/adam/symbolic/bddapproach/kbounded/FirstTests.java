package uniolunisaar.adam.symbolic.bddapproach.kbounded;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uniol.apt.analysis.exception.UnboundedException;
import uniol.apt.io.parser.ParseException;
import uniolunisaar.adam.logic.exceptions.NetNotConcurrencyPreservingException;
import uniolunisaar.adam.ds.exceptions.NetNotSafeException;
import uniolunisaar.adam.ds.exceptions.NoStrategyExistentException;
import uniolunisaar.adam.ds.exceptions.CouldNotFindSuitableWinningConditionException;
import uniolunisaar.adam.ds.exceptions.NoSuitableDistributionFoundException;
import uniolunisaar.adam.logic.exceptions.ParameterMissingException;
import uniolunisaar.adam.ds.exceptions.SolverDontFitPetriGameException;
import uniolunisaar.adam.ds.exceptions.NotSupportedGameException;
import uniolunisaar.adam.ds.exceptions.SolvingException;
import uniolunisaar.adam.logic.util.AdamTools;
import uniolunisaar.adam.tools.Logger;

/**
 *
 * @author Manuel Gieseking
 */
@Test
public class FirstTests {

    private static final String inputDir = System.getProperty("examplesfolder") + "/safety/kbounded";
    private static final String outputDir = System.getProperty("testoutputfolder") + "/safety/kbounded/";

    @BeforeClass
    public void createFolder() {
        Logger.getInstance().setVerbose(true);
        (new File(outputDir)).mkdirs();
    }

    private void testExamples(String name, boolean hasStrat) throws IOException, SolvingException, NetNotSafeException, NetNotConcurrencyPreservingException, InterruptedException, NoStrategyExistentException, NoSuitableDistributionFoundException, UnboundedException, ParseException, SolverDontFitPetriGameException, NotSupportedGameException, CouldNotFindSuitableWinningConditionException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ParameterMissingException {
        final String path = inputDir + File.separator;
        BDDkBoundedSolver solv = BDDkBoundedSolverFactory.getInstance().getSolver(path + name + ".apt", true);
//        System.out.println("ExStrat" + solv.existsWinningStrategy());
//        solv.getGraphStrategy();
//        BDDGraph g = BDDGraphBuilder.builtGraphStrategy(solv, 5);
//        BDDTools.saveGraph2PDF(outputDir + name + "_gg_strat_d5", g, solv);
//        BDDTools.saveGraph2PDF(outputDir + name + "_graphgame", solv.getGraphGame(), solv);
//        BDDTools.saveGraph2PDF(outputDir + name + "_gg_strat", solv.getGraphStrategy(), solv);
        AdamTools.savePG2PDF(outputDir + name, solv.getGame(), false);
//        Assert.expectThrows(UnsupportedOperationException.class, solv.exWinStrat());
        Assert.assertEquals(0, solv.getDcs_length(), name);
    }

    @Test
    public void testFirstExample() throws IOException, SolvingException, NetNotSafeException, NetNotConcurrencyPreservingException, InterruptedException, NoStrategyExistentException, NoSuitableDistributionFoundException, UnboundedException, ParseException, SolverDontFitPetriGameException, NotSupportedGameException, CouldNotFindSuitableWinningConditionException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ParameterMissingException {
        testExamples("firstTest", true);
    }
}