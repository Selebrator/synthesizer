package uniolunisaar.adam.symbolic.bddapproach.solver;

import uniolunisaar.adam.ds.solver.SolverOptions;

/**
 *
 * @author Manuel Gieseking
 */
public class BDDSolverOptions extends SolverOptions {

    //"buddy", "cudd", "cal", "j", "java", "jdd", "test", "typed",
    private String libraryName = "buddy";
    private int maxIncrease = 100000000;
    private int initNodeNb = 1000000;
    private int cacheSize = 1000000;
    private boolean gg = false;
    private boolean ggs = false;
    private boolean pgs = true;

    public BDDSolverOptions() {
        super("bdd");
    }

    public BDDSolverOptions(String name, String libraryName, int maxIncrease, int initNodeNb, int cacheSize) {
        super(name);
        this.libraryName = libraryName;
        this.maxIncrease = maxIncrease;
        this.initNodeNb = initNodeNb;
        this.cacheSize = cacheSize;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public void setMaxIncrease(int maxIncrease) {
        this.maxIncrease = maxIncrease;
    }

    public void setInitNodeNb(int initNodeNb) {
        this.initNodeNb = initNodeNb;
    }

    public void setCacheSize(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public int getMaxIncrease() {
        return maxIncrease;
    }

    public int getInitNodeNb() {
        return initNodeNb;
    }

    public int getCacheSize() {
        return cacheSize;
    }

    public boolean isGg() {
        return gg;
    }

    public void setGg(boolean gg) {
        this.gg = gg;
    }

    public boolean isGgs() {
        return ggs;
    }

    public void setGgs(boolean ggs) {
        this.ggs = ggs;
    }

    public boolean isPgs() {
        return pgs;
    }

    public void setPgs(boolean pgs) {
        this.pgs = pgs;
    }
}