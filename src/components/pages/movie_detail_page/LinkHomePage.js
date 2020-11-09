import React from 'react';
import PropTypes from "prop-types";

const LinkHomePage = (props) => {
    if (props.homepage === "") {
        return (<div>
            <img src={"/images/not_available64.png"} alt="No homepage" style={{margin: "0 12px"}}/>
        </div>);
    }
    return (<div className={"homepage-button-container"}>
        <a href={props.homepage} target="_blank" rel="noopener noreferrer">
            <img src={"/images/movie_reel64.png"} alt="Homepage" style={{margin: "0 12px"}}/>
        </a>
    </div>);
}

LinkHomePage.propTypes = {
    homepage: PropTypes.string.isRequired
};


export default LinkHomePage;