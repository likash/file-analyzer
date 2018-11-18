import React from "react";
import { Button, withStyles } from '@material-ui/core'
import { Link } from 'react-router-dom'

const LinkButton = ({to, text, classes}) => (
    <Link to={to} className={classes.analyzeLink}>
        <Button>
            {text}
        </Button>
    </Link>
);

const styles = {
    analyzeLink: {       
        display: "flex",
        alignItems: "center"        
    }
}    

export default withStyles(styles)(LinkButton);