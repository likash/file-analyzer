import React from 'react';
import { analyzeTextRequest, clearUserStatistics } from 'actions';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import AnalyzeTextForm from 'components/AnalyzeTextForm';
import { Grid, withStyles } from '@material-ui/core'
import { files } from 'constants/routes/ui'
import TextStatistics from 'components/TextStatistics';

const styles = {
    formWrp: {
        paddingTop: "10%",
    }
}

class TextAnalyzerPage extends React.Component {
    constructor(props) {
        super(props);
        this.goToFiles = this.goToFiles.bind(this);
    }

    componentWillUnmount() {
        this.props.actions.clearUserStatistics();
    }

    goToFiles() {
        this.props.history.push(files);
    }

    renderTextStatistics() {
        const { statistics } = this.props;   
        if (!statistics) {
            return null;
        }
        return <TextStatistics statistics={statistics}/>;
    }
    
    render() {
        const { actions } = this.props;        
        return (
            <Grid container direction="column" alignItems="center">
                <AnalyzeTextForm 
                    onSubmit={actions.analyzeTextRequest}
                    handleCancel={this.goToFiles}
                    cancelText="Back to files"
                />
                {this.renderTextStatistics()}              
            </Grid>                     
        );
    }
}

const mapStateToProps = (state) => ({
    statistics: state.userTextStatistics
})

const mapDispatchToProps = (dispatch) => ({
    actions: bindActionCreators({
        analyzeTextRequest,
        clearUserStatistics
    }, dispatch)
})

export default withStyles(styles)(connect(mapStateToProps, mapDispatchToProps)(TextAnalyzerPage));

