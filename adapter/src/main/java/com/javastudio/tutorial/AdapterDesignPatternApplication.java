package com.javastudio.tutorial;

import com.javastudio.tutorial.adapters.SquarePegAdapter;
import com.javastudio.tutorial.round.RoundHole;
import com.javastudio.tutorial.round.RoundPeg;
import com.javastudio.tutorial.square.SquarePeg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdapterDesignPatternApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdapterDesignPatternApplication.class);

    public static void main(String[] args) {
        LOGGER.info("Application started!");

        new AdapterDesignPatternApplication().demo();
    }

    private void demo() {
        // Round fits round, no surprise.
        RoundHole hole = new RoundHole(5);
        RoundPeg rpeg = new RoundPeg(5);
        if (hole.fits(rpeg)) {
            System.out.println("Round peg r5 fits round hole r5.");
        }

        SquarePeg smallSqPeg = new SquarePeg(2);
        SquarePeg largeSqPeg = new SquarePeg(20);
        // hole.fits(smallSqPeg); // Won't compile.

        // Adapter solves the problem.
        SquarePegAdapter smallSqPegAdapter = new SquarePegAdapter(smallSqPeg);
        SquarePegAdapter largeSqPegAdapter = new SquarePegAdapter(largeSqPeg);
        if (hole.fits(smallSqPegAdapter)) {
            System.out.println("Square peg w2 fits round hole r5.");
        }
        if (!hole.fits(largeSqPegAdapter)) {
            System.out.println("Square peg w20 does not fit into round hole r5.");
        }
    }
}
