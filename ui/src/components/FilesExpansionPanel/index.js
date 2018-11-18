import React from 'react';
import PropTypes from 'prop-types';
import { withStyles } from '@material-ui/core/styles';
import ExpansionPanel from '@material-ui/core/ExpansionPanel';
import ExpansionPanelSummary from '@material-ui/core/ExpansionPanelSummary';
import ExpansionPanelDetails from '@material-ui/core/ExpansionPanelDetails';
import Typography from '@material-ui/core/Typography';
import ExpandMoreIcon from '@material-ui/icons/ExpandMore';
import { getLinesRouteByFileId } from 'constants/routes/ui';
import { Link } from 'react-router-dom';
import { Button } from '@material-ui/core';

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
  },
  detail: {
    flexDirection: "column"
  }
});

function FilesExpansionPanel(props) {
  const { classes, files } = props;
  return (
    <div className={classes.root}>    
    {
        files.map(file => (
            <ExpansionPanel key={file.id}>
                <ExpansionPanelSummary expandIcon={<ExpandMoreIcon />}>
                  <Typography className={classes.heading}>
                    {file.fileName}
                    <Link to={getLinesRouteByFileId(file.id)}>
                       <Button>
                         Show file lines statistics
                      </Button> 
                    </Link> 
                  </Typography>
                </ExpansionPanelSummary>
                <ExpansionPanelDetails className={classes.detail}>               
                    Location: {file.fileLocation}                 
                  <ul>
                    <li>
                      Longest word: {file.longestWord}
                    </li>
                    <li>
                      Shortest word: {file.shortestWord}
                    </li>
                    <li>
                      Average word length: {file.averageWordLength}
                    </li>
                    <li>
                      File length: {file.length}
                    </li>
                  </ul>                                             
                </ExpansionPanelDetails>
            </ExpansionPanel>      
        ))
    }      
    </div>
  );
}

FilesExpansionPanel.propTypes = {
  classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(FilesExpansionPanel);
