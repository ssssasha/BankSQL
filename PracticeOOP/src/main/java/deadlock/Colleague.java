package deadlock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Colleague {
    private static final Logger LOGGER = LogManager.getLogger(Colleague.class);
    public String name;

    public Colleague() {
    }

    public Colleague(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public synchronized void ask(Colleague c) {
        LOGGER.info("Initialize ask method for " + this.getName() + "...");
        LOGGER.info(this.name + " : " + c.getName() + " has asked me!");
        c.answer(this);
        LOGGER.info("Done...");
    }

    public synchronized void answer(Colleague col) {
        LOGGER.info("Initialize answer method for " + this.getName() + "...");
        LOGGER.info(this.name + " : " + col.getName() + " has answered me!");
        LOGGER.info("Done...");
    }
}
