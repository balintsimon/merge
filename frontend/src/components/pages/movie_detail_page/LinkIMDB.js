import React from 'react';
import PropTypes from 'prop-types';
import {IMDB_URL} from "../../../Constants";


const LinkIMDB = (props) => {

    return (
        <div className={"imdb-button-container"}>
            <a href={`${IMDB_URL}${props.imdbId}/`} target="_blank" rel="noopener noreferrer">
                <img src={"/images/imdb64.png"} alt="IMDB page" style={{margin: "0 12px"}}/>
            </a>
        </div>
    );
};

LinkIMDB.propTypes = {
    imdbId: PropTypes.string.isRequired
};

export default LinkIMDB;
