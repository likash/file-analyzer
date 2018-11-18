import React from 'react'
import { connect } from 'react-redux'
import { bindActionCreators } from 'redux'
import { getFilesRequest } from 'actions'
import FilesExpansionPanel from 'components/FilesExpansionPanel'
import './FilesListPage.css'
import { analyzeText } from 'constants/routes/ui'
import { Grid } from '@material-ui/core'
import LinkButton from 'components/LinkButton'

class FilesListPage extends React.Component {
    componentDidMount() {
        this.props.actions.getFilesRequest()
    }

    render() {
        const { files} = this.props
        return (
            <div className="files-table-wrp">
                <Grid container justify="space-between">
                <h2>
                    All files in DB:  
                </h2>                   
                    <LinkButton to={analyzeText} text="Analyze your text"/>
                </Grid>               

                <FilesExpansionPanel 
                    files={files}
                />
            </div>
        )
    }
}

const mapStateToProps = (state) => ({
    files: state.files
})

const mapDispatchToProps = (dispatch) => ({
    actions: bindActionCreators({
        getFilesRequest
    }, dispatch)
})

FilesListPage.defaultProps = {
    files: [
        {
            fileName: 'lol.txt',
            location: 'C://ocation',
            longestWord: 'Hello',
            shortestWord: 'hi',
            averageWordLength: 3,
            length: 1000,
        },
        {
            fileName: 'losdasdsdafl.txt',
            location: 'C://ocasdgfasdfasdation',
            longestWord: 'Hello',
            shortestWord: 'hi',
            averageWordLength: 3,
            length: 1000,
        }
    ]
}

export default connect(mapStateToProps, mapDispatchToProps)(FilesListPage);