import React from 'react';
import PropTypes from "prop-types";

const LinkYouTube = (props) => {
    const YOUTUBE_URL = "https://www.youtube.com/watch?v=";

    if (props.youtubeTrailer === "no-trailer") {
        return (<div>
            <img src={"/images/not_available64.png"} alt="No trailer" style={{margin: "0 12px"}}/>
        </div>);
    }
    return (<div className={"youtube-button-container"}>
        <a href={`${YOUTUBE_URL}${props.youtubeTrailer}/`} target="_blank" rel="noopener noreferrer">
            <img src={"/images/youtube64.png"} alt="Youtube video" style={{margin: "0 12px"}}/>
        </a>
    </div>);
};

LinkYouTube.propTypes = {
    youtubeTrailer: PropTypes.string.isRequired
};

export default LinkYouTube;