import React from 'react';
import PropTypes from 'prop-types';
import { withStyles } from '@material-ui/core/styles';
import ExpansionPanel from '@material-ui/core/ExpansionPanel';
import ExpansionPanelSummary from '@material-ui/core/ExpansionPanelSummary';
import ExpansionPanelDetails from '@material-ui/core/ExpansionPanelDetails';
import Typography from '@material-ui/core/Typography';
import ExpandMoreIcon from '@material-ui/icons/ExpandMore';

const styles = theme => ({
  root: {
    width: '100%',
  },
  heading: {
    display: "flex",
    width: "100%",
    justifyContent: "space-between",
    fontSize: theme.typography.pxToRem(23),
    fontWeight: theme.typography.fontWeightRegular,
    wordBreak: "break-all"
  },
  detail: {
    flexDirection: "column"
  },
  statisticsList: {
    wordBreak: "break-all"
  }
});

function LinesExpansionPanel(props) {
  const { classes, lines } = props;
  return (
    <div className={classes.root}>    
    {
        lines.map(line => (
            <ExpansionPanel key={line.id}>
                <ExpansionPanelSummary expandIcon={<ExpandMoreIcon />}>
                  <Typography className={classes.heading}>
                    {line.content}                
                  </Typography>
                </ExpansionPanelSummary>
                <ExpansionPanelDetails className={classes.detail}>  
                  <ul className={classes.statisticsList}>
                    <li>
                      Longest word: {line.longestWord}
                    </li>
                    <li>
                      Shortest word: {line.shortestWord}
                    </li>
                    <li>
                      Average word length: {line.averageWordLength}
                    </li>
                    <li>
                      Line length: {line.length}
                    </li>
                  </ul>                                             
                </ExpansionPanelDetails>
            </ExpansionPanel>      
        ))
    }      
    </div>
  );
}

LinesExpansionPanel.propTypes = {
  classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(LinesExpansionPanel);
