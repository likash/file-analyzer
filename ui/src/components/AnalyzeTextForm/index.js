import React from 'react';
import { Button, TextField, Grid, withStyles } from '@material-ui/core';

const styles = {
    fieldsWrp: {
        width: "100%"
    },
    analyzeForm: {
        width: "100%",
        maxWidth: "700px",
        minWidth: "300px"
    }
}
class AnalyzeTextForm extends React.Component {
    constructor (props) {
        super(props);
        this.state = {
            text: ""
        }
    }
    
    handleChange = ({target}) => {
        this.setState({
           text: target.value
        });
    }

    handleSubmit = (event) => {
        event.preventDefault();
        this.props.onSubmit(this.state.text);
    }

    render() {

        return(
            <form onSubmit={this.handleSubmit} className={this.props.classes.analyzeForm}>
                <Grid container direction = "column" justify="center" className={this.props.classes.fieldsWrp}>
                    <TextField         
                        label="Analyze your own text!"
                        multiline
                        value={this.state.text}
                        onChange={this.handleChange}
                        margin="normal"                        
                        variant="outlined"
                        autoFocus
                    />
                    <Grid item container justify="space-between">
                        <Button onClick={this.props.handleCancel}>
                            {this.props.cancelText}
                        </Button>
                        <Button type="submit">
                            Analyze
                        </Button>
                    </Grid>
                </Grid>
            </form>
        );
    }
}

export default withStyles(styles)(AnalyzeTextForm);