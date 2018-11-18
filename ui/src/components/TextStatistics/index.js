import React from "react";
import { Grid, withStyles } from "@material-ui/core";
import LinesExpansionPanel from 'components/LinesExpansionPanel';

const styles = {
    statisticsWrp: {
        width: "100%",
        maxWidth: "700px",
        minWidth: "300px"
    },
    statisticsList: {
        wordBreak: "break-all"
    } 
}

const TextStatistics = ({statistics, classes}) => (            
    <Grid item className={classes.statisticsWrp}>
        <h3>Text statistics:</h3>
        <ul className={classes.statisticsList}>
            <li>
                Longest word: {statistics.longestWord}
            </li>
            <li>
                Shortest word: {statistics.shortestWord}
            </li>
            <li>
                average word length: {statistics.averageWordLength}
            </li>
            <li>
                Text length: {statistics.length}
            </li>
        </ul>
        <LinesExpansionPanel lines={statistics.lines}/>
    </Grid>            
);

export default withStyles(styles)(TextStatistics);