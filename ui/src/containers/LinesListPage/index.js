import React from 'react'
import { connect } from 'react-redux'
import { bindActionCreators } from 'redux'
import { getLinesRequest } from 'actions'
import LinesExpansionPanel from 'components/LinesExpansionPanel'
import { files } from 'constants/routes/ui'
import { Grid } from '@material-ui/core'
import LinkButton from 'components/LinkButton'

class LinesListPage extends React.Component {
    componentDidMount() {        
        this.props.actions.getLinesRequest(this.props.match.params.file_id)
    }

    render() {
        const { lines } = this.props
        return (
            <div className="files-table-wrp">
            <Grid container justify="space-between">
                <h2>Lines statistics:</h2>
                <LinkButton to={files} text="Back to files"/>
            </Grid>               
            
            <LinesExpansionPanel 
                lines={lines}
            />
            </div>
        )
    }
}

const mapStateToProps = (state) => ({
    lines: state.lines
})

const mapDispatchToProps = (dispatch) => ({
    actions: bindActionCreators({
        getLinesRequest
    }, dispatch)
});

LinesListPage.defaultProps = {
    lines: [
        {
            id: "1",
            content: 'Danil ne prav pozhizni',
            longestWord: 'Hello',
            shortestWord: 'hi',
            averageWordLength: 3,
            length: 1000,
        },
        {
            id: "2",
            content: 'Wicker Man lutchshaya pop-gruppa 80-h ',
            longestWord: 'Hello',
            shortestWord: 'hi',
            averageWordLength: 3,
            length: 1000,
        }
    ]
}

export default connect(mapStateToProps, mapDispatchToProps)(LinesListPage)