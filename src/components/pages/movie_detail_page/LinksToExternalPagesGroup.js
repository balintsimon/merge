import React from 'react';
import LinkHomePage from "./LinkHomePage";
import LinkIMDB from "./LinkIMDB";
import LinkYouTube from "./LinkYouTube";

const LinksToExternalPagesGroup = (props) => {

    return (
        <div className="col-md-12 d-flex justify-content-center" style={{
            height: "100px",
            backgroundColor: "#2e2e2e",
            padding: "16px"
        }}>
            <LinkHomePage homepage={props.homepage}/>
            <LinkIMDB imdbId={props.imdbId}/>
            <LinkYouTube youtubeTrailer={props.youtubeTrailer}/>
        </div>
    );
}

export default LinksToExternalPagesGroup;